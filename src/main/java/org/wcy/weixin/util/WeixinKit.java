package org.wcy.weixin.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.UnsupportedCharsetException;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.wcy.weixin.quartz.RefreshAccessTokenTask;

public class WeixinKit {

	public static String postReq(String url, String data, String type) {
		CloseableHttpClient client = null;
		CloseableHttpResponse resp = null;
		
		try {
			client = HttpClients.createDefault();
			URL turl = new URL(url);
			URI uri = new URI(turl.getProtocol(), turl.getHost(), turl.getPath(), turl.getQuery(), null);
			HttpPost httpPost = new HttpPost(uri);
			httpPost.addHeader("Content-Type", type);
			StringEntity entity = new StringEntity(data, "UTF-8");
			httpPost.setEntity(entity);
			resp = client.execute(httpPost);
			int sc = resp.getStatusLine().getStatusCode();
			if(sc >= 200 && sc < 300) {
				String str = EntityUtils.toString(resp.getEntity(),"UTF-8");
				return str;
			}
		} catch (UnsupportedCharsetException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(client != null) client.close();
				if(resp != null) resp.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static String reqGet(String url) {
		CloseableHttpClient client = null;
		CloseableHttpResponse resp = null;
		
		try {
			client = HttpClients.createDefault();
			URL turl = new URL(url);
			URI uri = new URI(turl.getProtocol(), turl.getHost(), turl.getPath(), turl.getQuery(), null);
			HttpGet get = new HttpGet(uri);
			resp = client.execute(get);
			int sc = resp.getStatusLine().getStatusCode();
			if(sc>=200 && sc<300) {
				String str = EntityUtils.toString(resp.getEntity(),"UTF-8");
				return str;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(client != null) client.close();
				if(resp != null) resp.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static String replaceAccessToken(String url) {
		url = url.replaceAll("ACCESS_TOKEN", RefreshAccessTokenTask.ACCESS_TOKEN);
		return url;
	}
	
}
 