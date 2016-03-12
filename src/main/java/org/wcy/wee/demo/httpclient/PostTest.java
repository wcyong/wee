package org.wcy.wee.demo.httpclient;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class PostTest {

	public static void main(String[] args) throws IOException {
		
		//创建Httpclient对象
		CloseableHttpClient client = HttpClients.createDefault();
		
		//创建http POST请求
		HttpPost httpPost = new HttpPost("http://www.oschina.net/");
		
		//伪装成浏览器
		httpPost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36");
		
		CloseableHttpResponse response = null;
		try {
			//执行请求
			response = client.execute(httpPost);
			//判断返回状态是否为200
			if(response.getStatusLine().getStatusCode() == 200) {
				String content = EntityUtils.toString(response.getEntity(), "UTF-8");
				System.out.println(content);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(response != null) {
				response.close();
			}
			client.close();
		}
	}
}
