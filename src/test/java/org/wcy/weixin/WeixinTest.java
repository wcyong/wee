package org.wcy.weixin;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.wcy.common.util.JsonUtil;
import org.wcy.weixin.json.AccessToken;
import org.wcy.weixin.json.ModelMsgData;
import org.wcy.weixin.json.TemplateMsg;
import org.wcy.weixin.media.MediaKit;
import org.wcy.weixin.model.WeixinFinalValue;
import org.wcy.weixin.model.WeixinMenu;
import org.wcy.weixin.msg.MessageKit;
import org.wcy.weixin.quartz.RefreshAccessTokenTask;
import org.wcy.weixin.util.SecurityKit;
import org.wcy.weixin.util.WeixinKit;

public class WeixinTest {

	private static final int ConnectionSocketFactory = 0;

	@Test
	public void testSha1() {
		String str = "hello";
		String sha1 = SecurityKit.sha1(str);
		System.out.println(sha1);
	}
	
	/**
	 * 获取access_token
	 */
	@Test
	public void testHttpClient() {
		CloseableHttpClient client = null;
		CloseableHttpResponse resp = null;
		try {
			client = HttpClients.createDefault();
			String url = WeixinFinalValue.ACCESS_TOKEN_URL;
			url = url.replaceAll("APPID", WeixinFinalValue.APPID);
			url = url.replaceAll("APPSECRET", WeixinFinalValue.APPSECRET);
			System.out.println(url);
			HttpGet get = new HttpGet(url);
			resp = client.execute(get);
			int statusCode = resp.getStatusLine().getStatusCode();
			if(statusCode >= 200 && statusCode < 300) {
				HttpEntity entity = resp.getEntity();
				String content = EntityUtils.toString(entity);
				AccessToken at = (AccessToken) JsonUtil.getInstance().json2obj(content, AccessToken.class);
				System.out.println(at.getAccess_token());
				System.out.println(at.getExpires_in());
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(resp != null) resp.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(client != null) client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 添加菜单测试
	 */
	@Test
	public void testMenu() {
		try {
			List<WeixinMenu> wms = new ArrayList<WeixinMenu>();
			WeixinMenu wm1 = new WeixinMenu();
			wm1.setId(1);
			wm1.setName("学习网站");
			wm1.setType("view");
			wm1.setUrl("http://wwss8007.6655.la/wee/demo/bootstrap/demo01.jsp");
			wms.add(wm1);
			
			WeixinMenu wm2 = new WeixinMenu();
			wm2.setName("测试资源");
			
			List<WeixinMenu> wm2Sub = new ArrayList<WeixinMenu>();
			wm1 = new WeixinMenu();
			wm1.setId(2);
			wm1.setName("事件测试");
			wm1.setType("click");
			wm1.setKey("A0001");
			wm2Sub.add(wm1);
			
			wm1 = new WeixinMenu();
			wm1.setId(2);
			wm1.setName("扫描测试");
			wm1.setType("pic_sysphoto");
			wm1.setKey("rselfmenu_1_0");
			wm2Sub.add(wm1);
			wm2.setSub_button(wm2Sub);
			
			wms.add(wm2);
			Map<String,List<WeixinMenu>> maps = new HashMap<String,List<WeixinMenu>>();
			maps.put("button",wms);
			String json = JsonUtil.getInstance().obj2json(maps);
			
			CloseableHttpClient client = HttpClients.createDefault();
			String url = WeixinFinalValue.MENU_ADD;
			url = url.replace("ACCESS_TOKEN", RefreshAccessTokenTask.ACCESS_TOKEN);
			
			

			URL url1 = new URL(url);
			URI uri = new URI(url1.getProtocol(), url1.getHost(), url1.getPath(), url1.getQuery(), null);
			HttpPost post = new HttpPost(uri);
			
			post.addHeader("Content-Type","application/json");
			StringEntity entity = new StringEntity(json, 
					ContentType.create("application/json", "utf-8"));
			post.setEntity(entity);
			CloseableHttpResponse resp = client.execute(post);
			int sc = resp.getStatusLine().getStatusCode();
			if(sc>=200&&sc<300) {
				System.out.println(EntityUtils.toString(resp.getEntity()));
			}
		} catch (UnsupportedCharsetException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加自己菜单
	 */
	@Test
	public void testAddMenu2() {
		List<WeixinMenu> wms = new ArrayList<WeixinMenu>();
		WeixinMenu wm1 = new WeixinMenu();
		wm1.setId(100);
		wm1.setName("学习");
		wm1.setKey("A0001");
		wm1.setType("click");
		List<WeixinMenu> wmSub = new ArrayList<WeixinMenu>();
		WeixinMenu subwm1 = new WeixinMenu();
		subwm1.setId(101);
		subwm1.setKey("A0001");
		subwm1.setName("学习资源");
		subwm1.setType("click");
		wmSub.add(subwm1);
		subwm1 = new WeixinMenu();
		subwm1.setId(102);
		subwm1.setName("学习网站");
		subwm1.setType("view");
		subwm1.setUrl("http://www.konghao.org");
		wmSub.add(subwm1);
		wm1.setSub_button(wmSub);
		wms.add(wm1);
		
		wm1 = new WeixinMenu();
		wm1.setId(200);
		wm1.setName("生活");
		wm1.setKey("B0001");
		wm1.setType("click");
		wms.add(wm1);
		
		wm1 = new WeixinMenu();
		wm1.setId(300);
		wm1.setName("娱乐");
		wm1.setKey("C0001");
		wm1.setType("click");
		wmSub = new ArrayList<WeixinMenu>();
		subwm1 = new WeixinMenu();
		subwm1.setId(301);
		subwm1.setKey("C0001");
		subwm1.setName("电影");
		subwm1.setType("click");
		wmSub.add(subwm1);
		subwm1 = new WeixinMenu();
		subwm1.setId(302);
		subwm1.setName("音乐");
		subwm1.setType("click");
		subwm1.setKey("C0001");
		wmSub.add(subwm1);
		wm1.setSub_button(wmSub);
		wms.add(wm1);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("button", wms);
		
		String json = JsonUtil.getInstance().obj2json(map);
		
		String url = WeixinFinalValue.MENU_ADD;
		url = WeixinKit.replaceAccessToken(url);
		String rs = WeixinKit.postReq(url, json, "application/json");
		System.out.println(rs);
	}
	
	/**
	 * 模板消息发送测试
	 */
	@Test
	public void testPostTemplateMsg() {
		TemplateMsg tm = new TemplateMsg();
		tm.setTouser("o_CQ1wzWsq4Jp_WLz7nL1qUVHJXk");
		tm.setTemplate_id("86Jr1Wd7CJCdNvYkSoq6DWv3UgP7py0AHS4qARCLXKo");
		tm.setUrl("www.konghao.org");
		tm.setTopcolor("#ff0000");
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("num", new ModelMsgData("100", "#ff0000"));
		tm.setData(data);
		MessageKit.postTemplateMsg(tm);
	}
	
	@Test
	public void testTxtMsgSendAll() {
		String url = WeixinFinalValue.MSG_SEND_ALL;
		url = WeixinKit.replaceAccessToken(url);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("is_to_all", true);
		map.put("filter", filter);
		Map<String, Object> text = new HashMap<String, Object>();
		text.put("content", "这是一条群发消息！");
		map.put("text", text);
		map.put("msgtype", "text");
		String json = JsonUtil.getInstance().obj2json(map);
		System.out.println(json);
		String rs = WeixinKit.postReq(url, json, "application/json");
		System.out.println(rs);
	}
	
	@Test
	public void testImgMsgSendAll() {
		String mediaId = "zc7RtSDZBKsfjoXW8Q7b90EXEi8GHEjAj74iECgcG_fHsY8EMvU7wk3Ry8WLmh1V";
		String url = WeixinFinalValue.MSG_SEND_ALL;
		url = WeixinKit.replaceAccessToken(url);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("is_to_all", true);
		map.put("filter", filter);
		Map<String, Object> text = new HashMap<String, Object>();
		text.put("content", "这是一条群发消息！");
		map.put("text", text);
		map.put("msgtype", "mpnews");
		
		Map<String, Object> mpnews = new HashMap<String, Object>();
		mpnews.put("media_id", mediaId);
		map.put("mpnews", mpnews);
		
		String json = JsonUtil.getInstance().obj2json(map);
		System.out.println(json);
		String rs = WeixinKit.postReq(url, json, "application/json");
		System.out.println(rs);
	}
	
	@Test
	public void testPostMedia() {
		String mid = MediaKit.postMedia("G:/100.png", "image");
		System.out.println(mid);
	}
	
	@Test
	public void testGetMedia() {
		try {
			MediaKit.getMedia("B-h4ZBPW0MUX-kqkf-saYShb_W0Ee-XxXxG4i6EsdhNvILjHvl_hDcp4BadMfySD",new File("f:/aaaa.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
