package org.wcy.wee.demo.httpclient;

import java.net.URI;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetParamTest {

	public static void main(String[] args) throws Exception {
		
		//创建Httpclient对象
		CloseableHttpClient client = HttpClients.createDefault();
		//定义请求的参数
		URI uri = new URIBuilder("http://www.baidu.com/s").setParameter("wd", "java").build();
		//创建http GET请求
		HttpGet httpGet = new HttpGet(uri);
		
		CloseableHttpResponse response = null;
		try {
			//执行请求
			response = client.execute(httpGet);
			//判断返回状态是否为200
			if(response.getStatusLine().getStatusCode() == 200) {
				String content = EntityUtils.toString(response.getEntity(), "UTF-8");
				System.out.println(content);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
                response.close();
            }
            client.close();
		}
		
	}
}
