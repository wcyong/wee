package org.wcy.wee.solrj;

import java.util.Arrays;
import java.util.List;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.junit.Before;
import org.junit.Test;
import org.wcy.wee.demo.solrj.pojo.Foo;
import org.wcy.wee.demo.solrj.service.SolrjService;

public class SolrjServiceTest {

	private SolrjService solrjService;

	@Before
	public void setUp() {
		String url = "http://localhost:8983/solr/test_core";
		// 定义solr的server
		HttpSolrClient httpSolrClient = new HttpSolrClient(url);
		// 设置响应解析器
		httpSolrClient.setParser(new XMLResponseParser());
		// 建立连接的最长时间
		httpSolrClient.setConnectionTimeout(500);

		solrjService = new SolrjService(httpSolrClient);
	}

	/**
	 * 添加,修改（id相同则修改）
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAdd() throws Exception {
		Foo foo = new Foo();
		foo.setId("333");//id相同时是修改操作
		foo.setTitle("SolrJ是操作Solr的JAVA客户端，它提供了增加、修改、删除、查询Solr索引的JAVA接口xxx");
		this.solrjService.add(foo);

	}

	/**
	 * 删除
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {
		solrjService.delete(Arrays.asList("2222222222222222"));
	}

	/**
	 * 查询
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSearch() throws Exception {
		List<Foo> foos = solrjService.search("*", 1, 10);
		for (Foo f : foos) {
			System.out.println(f);
		}
	}

	/**
	 * 根据查询条件删除
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteByQuery() throws Exception {
		solrjService.deleteByQuery("*:*");
	}

}
