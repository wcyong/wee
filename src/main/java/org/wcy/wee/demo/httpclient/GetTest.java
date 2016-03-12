package org.wcy.wee.demo.httpclient;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetTest {

	public static void main(String[] args) throws IOException {
		// 创建Httpclient对象
		CloseableHttpClient client = HttpClients.createDefault();
		// 创建http GET请求
		HttpGet httpGet = new HttpGet("http://www.baidu.com/");
		
		CloseableHttpResponse response = null;
		try {
			//执行请求
			response = client.execute(httpGet);
			//判断返回状态是否为200
			if(response.getStatusLine().getStatusCode() == 200) {
				String content = EntityUtils.toString(response.getEntity(), "UTF-8");
				System.out.println("内容长度："+content.length());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(response != null) {
				response.close();
			}
			client.close();
		}

	}
}
