package org.wcy.wee.demo.httpclient;

import java.io.IOException;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 设置请求参数
 * @author wcyong
 *
 * @date   2016年3月12日
 */
public class RequestConfigTest {

	public static void main(String[] args) throws IOException {
		// 创建Httpclient对象
		CloseableHttpClient client = HttpClients.createDefault();

		// 创建http GET请求
		HttpGet httpGet = new HttpGet("http://www.baidu.com/");

		// 构建请求配置信息
		RequestConfig config = RequestConfig.custom().setConnectTimeout(1000)// 创建连接的最长时间
				.setConnectionRequestTimeout(500)// 从连接池中获取到连接的最长时间
				.setSocketTimeout(10 * 1000)// 数据传输的最长时间
				.build();
		// 设置请求配置信息
		httpGet.setConfig(config);

		CloseableHttpResponse response = null;

		try {
			// 执行请求
			response = client.execute(httpGet);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				String content = EntityUtils.toString(response.getEntity(), "UTF-8");
				System.out.println(content);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
				response.close();
			}
			client.close();
		}

	}
}
