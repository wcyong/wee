package org.wcy.wee;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;
import org.wcy.wee.common.util.StreamUtil;

public class TestHttpClient {

	@Test
	public void testGet() throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet requet = new HttpGet("");
		HttpResponse response = client.execute(requet);
		int code = response.getStatusLine().getStatusCode();
		if(code == 200) {
			InputStream is = response.getEntity().getContent();
			String result = StreamUtil.readStream(is);
			System.out.println(result);
		} else {
			System.out.println("请求失败");
		}
	}
	
	@Test
	public void testPost() throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		NameValuePair nameValuePair = new BasicNameValuePair("name", "测试");
		NameValuePair nameValuePair2 = new BasicNameValuePair("password", "123456");
		parameters.add(nameValuePair);
		parameters.add(nameValuePair2);
		UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(parameters,"UTF-8");
		HttpPost request = new HttpPost("");
		request.setEntity(encodedFormEntity);
		HttpResponse response = client.execute(request);
		int code = response.getStatusLine().getStatusCode();
		if(code == 200) {
			InputStream is = response.getEntity().getContent();
			String result = StreamUtil.readStream(is);
			System.out.println(result);
		} else {
			System.out.println("请求失败");
		}
	}
}
