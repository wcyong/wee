package org.wcy.wee.weixin.msg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;
import org.wcy.wee.common.util.JsonUtil;
import org.wcy.wee.weixin.json.TemplateMsg;
import org.wcy.wee.weixin.model.WeixinFinalValue;
import org.wcy.wee.weixin.util.WeixinKit;

public class MessageKit {
	
	public static Map<String, String> replyMsgs = new HashMap<String, String>();
	
	static {
		replyMsgs.put("java", "学习网站www.konghao.org");
		replyMsgs.put("哈哈", "你笑什么？");
		replyMsgs.put("hello", "Hello World!");
		replyMsgs.put("你好", "欢迎关注!");
	}

	/**
	 * 将xml转换为map
	 * @param request
	 * @return
	 * @throws IOException 
	 * @throws DocumentException 
	 */
	public static Map<String, String> reqMsg2Map(HttpServletRequest request) throws IOException {
		try {
			String xml = req2xml(request);
			Map<String, String> maps = new HashMap<String, String>();
			Document document = DocumentHelper.parseText(xml);
			Element root = document.getRootElement();
			@SuppressWarnings("unchecked")
			List<Element> eles = root.elements();
			for(Element ele : eles) {
				maps.put(ele.getName(), ele.getTextTrim());
			}
			return maps;
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String req2xml(HttpServletRequest request) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(),"UTF-8"));
		String line = null;
		StringBuffer sb = new StringBuffer();
		while((line=br.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}

	/**
	 * 消息处理
	 * @param maps
	 * @throws IOException 
	 */
	public static String handlerMsg(Map<String, String> maps) throws IOException {
		String msgType = maps.get("MsgType");
		if(msgType.equals(WeixinFinalValue.MSG_EVENT_TYPE)) {
		
		//文本消息
		} else if(msgType.equals(WeixinFinalValue.MSG_TEXT_TYPE)) {
			return textTypeHandler(maps);
		//图片消息
		} else if(msgType.equals(WeixinFinalValue.MSG_IMAGE_TYPE)) {
			String mediaId = "zc7RtSDZBKsfjoXW8Q7b90EXEi8GHEjAj74iECgcG_fHsY8EMvU7wk3Ry8WLmh1V";
			return imageTypeHandler(maps, mediaId);
		}
		return null;
	}

	private static String imageTypeHandler(Map<String, String> maps, String mediaId) throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("ToUserName", maps.get("FromUserName"));
		map.put("FromUserName", maps.get("ToUserName"));
		map.put("CreateTime", new Date().getTime()+"");
		map.put("MsgType", "image");
		map.put("Image", "<MediaId>"+mediaId+"</MediaId>");
		
		return map2xml(map);
	}

	private static String textTypeHandler(Map<String, String> maps) throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("ToUserName", maps.get("FromUserName"));
		map.put("FromUserName", maps.get("ToUserName"));
		map.put("CreateTime", new Date().getTime()+"");
		map.put("MsgType", "text");
		String replyContent = "您请求的消息的内容不正确！";
		String con = maps.get("Content");
		if(replyMsgs.containsKey(con)) {
			replyContent = replyMsgs.get(con);
		}
		map.put("Content", replyContent);
		
		return map2xml(map);
	}

	/**
	 * 将map转换为xml
	 * @param map
	 * @return
	 * @throws IOException 
	 */
	private static String map2xml(Map<String, String> map) throws IOException {
		Document d = DocumentHelper.createDocument();
		Element root = d.addElement("xml");
		Set<String> keys = map.keySet();
		for(String key : keys) {
			root.addElement(key).addText(map.get(key));
		}
		StringWriter sw = new StringWriter();
		XMLWriter xmlWriter = new XMLWriter(sw);
		xmlWriter.setEscapeText(false);
		xmlWriter.write(d);
		return sw.toString();
	}
	
	/**
	 * 模板消息发送
	 * @param tm
	 * @return
	 */
	public static String postTemplateMsg(TemplateMsg tm) {
		String url = WeixinKit.replaceAccessToken(WeixinFinalValue.SEND_TEMPLATE_MSG);
		String json = JsonUtil.getInstance().obj2json(tm);
		String result = WeixinKit.postReq(url, json, "application/json");
		return result;
		
		/*CloseableHttpClient client = null;
		CloseableHttpResponse resp = null;
		
		try {
			client = HttpClients.createDefault();
			
			String url = replaceAccessToken(WeixinFinalValue.SEND_TEMPLATE_MSG);
			URL url1 = new URL(url);
			URI uri = new URI(url1.getProtocol(), url1.getHost(), url1.getPath(), url1.getQuery(), null);
			
			HttpPost httpPost = new HttpPost(uri);
			httpPost.addHeader("Content-Type", "application/json");
			String json = JsonUtil.getInstance().obj2json(tm);
			StringEntity entity = new StringEntity(json, "UTF-8");
			httpPost.setEntity(entity);
			
			resp = client.execute(httpPost);
			int sc = resp.getStatusLine().getStatusCode();
			if(sc >=200 && sc < 300) {
				String str = EntityUtils.toString(resp.getEntity());
				System.out.println(str);
				return str;
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
		} finally {
			try {
				if(client != null) client.close();
				if(resp != null) resp.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;*/
	}

}
