package org.wcy.wee.solrj;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.junit.Test;
import org.wcy.wee.common.vo.EasyUIResult;
import org.wcy.wee.demo.solrj.pojo.Item;

/**
 * 将数据提交到solr中
 * 
 * @author wcyong
 *
 */
public class ItemDataImport {

	private String baseURL = "http://manage.wee.com/rest/item?page={page}&rows=100";

	@Test
	public void handlerData() throws Exception {
		String solrUrl = "http://localhost:8983/solr/item_core";
		HttpSolrClient httpSolrClient = new HttpSolrClient(solrUrl);
		// 设置响应解析器
		httpSolrClient.setParser(new XMLResponseParser());
		// 建立连接的最长时间
		httpSolrClient.setMaxTotalConnections(500);

		// 查询数据
		Integer page = 1;
		Integer pageSize = 0;
		do {
			String url = StringUtils.replace(baseURL, "{page}", page + "");
			String jsonData = doGet(url);
			EasyUIResult easyUIResult = EasyUIResult.formatToList(jsonData, Item.class);
			List<Item> items = (List<Item>) easyUIResult.getRows();
			pageSize = items.size();
			page++;

			httpSolrClient.addBeans(items);
			httpSolrClient.commit();

		} while (pageSize == 100);
	}

	public static String doGet(String url) throws Exception {
		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();

		// 创建http GET请求
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.118 Safari/537.36");

		CloseableHttpResponse response = null;
		try {
			// 执行请求
			response = httpclient.execute(httpGet);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				return EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} finally {
			if (response != null) {
				response.close();
			}
			// 相当于关闭浏览器
			httpclient.close();
		}
		return null;
	}
}
