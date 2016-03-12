package org.wcy.wee.demo.httpclient;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

/**
 * 连接池管理
 * @author wcyong
 *
 * @date   2016年3月12日
 */
public class HttpConnectManagerTest {

	public static void main(String[] args) throws IOException {
		PoolingHttpClientConnectionManager pool = new PoolingHttpClientConnectionManager();
		//设置最大连接数
		pool.setMaxTotal(200);
		//设置每个主机地址的并发数
		pool.setDefaultMaxPerRoute(20);
		
		deGet(pool);
		deGet(pool);
	}
	
	public static void deGet(PoolingHttpClientConnectionManager pool) throws IOException {
		CloseableHttpClient client = HttpClients.custom().setConnectionManager(pool).build();
		
		//创建http GET请求
		HttpGet httpGet = new HttpGet("http://www.baidu.com/");
		
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
		}finally {
            if (response != null) {
                response.close();
            }
            // 此处不能关闭httpClient，如果关闭httpClient，连接池也会销毁
            // httpClient.close();
        }
	}
}
