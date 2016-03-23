package org.wcy.wee.demo.solrj.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.beans.DocumentObjectBinder;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.wcy.wee.demo.solrj.pojo.Foo;

public class SolrjService {

	// 定义http的solr服务
	private HttpSolrClient httpSolrClient;

	public SolrjService(HttpSolrClient httpSolrClient) {
		this.httpSolrClient = httpSolrClient;
	}

	/**
	 * 新增数据到solr服务
	 * 
	 * @param foo
	 * @throws Exception
	 */
	public void add(Foo foo) throws Exception {
		// 添加数据到solr服务器
		this.httpSolrClient.addBean(foo);
		// 提交
		this.httpSolrClient.commit();
	}

	/**
	 * 删除
	 * 
	 * @param ids
	 * @throws Exception
	 */
	public void delete(List<String> ids) throws Exception {
		this.httpSolrClient.deleteById(ids);
		this.httpSolrClient.commit();
	}

	/**
	 * 查询
	 * 
	 * @param keywords
	 * @param page
	 * @param rows
	 * @return
	 * @throws IOException
	 * @throws SolrServerException
	 */
	public List<Foo> search(String keywords, Integer page, Integer rows) throws Exception {
		// 构造搜索条件
		SolrQuery solrQuery = new SolrQuery();
		// 搜索关键词
		solrQuery.setQuery("title:" + keywords);
		// 设置分页 start=0就是从0开始，，rows=5当前返回5条记录，第二页就是变化start这个值为5就可以了。
		solrQuery.setStart((Math.max(page, 1) - 1) * rows);
		solrQuery.setRows(rows);

		// 是否需要高亮
		boolean isHighlighting = !StringUtils.equals("*", keywords) && StringUtils.isNotEmpty(keywords);

		// 设置高亮
		if (isHighlighting) {
			// 开启高亮组件
			solrQuery.setHighlight(true);
			// 高亮字段
			solrQuery.addHighlightField("title");
			// 标记，高亮关键字前缀
			solrQuery.setHighlightSimplePre("<em>");
			// 后缀
			solrQuery.setHighlightSimplePost("</em>");
		}

		// 执行查询
		QueryResponse queryResponse = this.httpSolrClient.query(solrQuery);
		
		/*SolrDocumentList solrDocList = queryResponse.getResults();
		DocumentObjectBinder binder = new DocumentObjectBinder();
		List<Foo> foos = binder.getBeans(Foo.class, solrDocList);*/
		
		List<Foo> foos = queryResponse.getBeans(Foo.class);
		
		if (isHighlighting) {
			// 将高亮的标题数据写回到数据对象中
			Map<String, Map<String, List<String>>> map = queryResponse.getHighlighting();
			for (Map.Entry<String, Map<String, List<String>>> highlighting : map.entrySet()) {
				for (Foo foo : foos) {
					if (!highlighting.getKey().equals(foo.getId().toString())) {
						continue;
					}
					foo.setTitle(StringUtils.join(highlighting.getValue().get("title"), ""));
					break;
				}
			}
		}

		return foos;
	}
	
	/**
	 * 根据查询条件删除
	 * @param query
	 * @throws SolrServerException
	 * @throws IOException
	 */
	public void deleteByQuery(String query) throws SolrServerException, IOException {
		httpSolrClient.deleteByQuery("*:*");
		httpSolrClient.commit();
	}
}
