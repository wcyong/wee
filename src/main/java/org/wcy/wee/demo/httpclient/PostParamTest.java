package org.wcy.wee.demo.httpclient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class PostParamTest {

	public static void main(String[] args) throws IOException {
		
		//创建Httpclient对象
		CloseableHttpClient client = HttpClients.createDefault();
		
		//创建http POST请求
		HttpPost httpPost = new HttpPost("http://www.oschina.net/");
		
		//设置2个post参数，一个是scope、一个是q
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		parameters.add(new BasicNameValuePair("scope", "project"));
		parameters.add(new BasicNameValuePair("q", "java"));
		//构造一个form表单式的实体
		UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
		//将请求实体设置到httpPost对象中
		httpPost.setEntity(formEntity);
		
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
