package org.wcy.wee.memcached;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wcy.wee.common.util.JsonUtil;
import org.wcy.wee.common.web.util.MemcachedUtil;
import org.wcy.wee.demo.memcached.TestUser;

import com.whalin.MemCached.MemCachedClient;

/**
 * memcached测试
 * 
 * @author wcyong
 *
 * @date   2015年10月11日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"/spring/applicationContext.xml", "/spring/applicationContext-memcached.xml"})
public class MemcachedTest {

	@Autowired
	private MemCachedClient memCachedClient;
	
	/**
	 * 添加
	 */
	@Test
	public void testAdd() {
		memCachedClient.set("wwss", "hello world!");
	}
	
	@Test
	public void testAdd2() {
		/**
		 * 实体对象必须要序列化才能存储
		 */
		TestUser u = new TestUser();
		u.setId("1");
		u.setUsername("admin");
		u.setNickname("管理员");
		memCachedClient.set("admin", u);
	}
	
	/**
	 * 获取值
	 */
	@Test
	public void testGet() {
		Object object = memCachedClient.get("wwss");
		System.out.println("==================================");
		System.out.println(object);
	}
	
	@Test
	public void testGet2() {
		TestUser object = (TestUser)memCachedClient.get("admin");
		System.out.println("===================================");
		System.out.println(object.getId());
		System.out.println(object.getNickname());
		System.out.println(object.getUsername());
		System.out.println("===================================");
	}
	
	/**
	 * 获取所有的key
	 */
	@Test
	public void testGetAllKeys() throws UnsupportedEncodingException {
		Map<String, Object> keysForMap = MemcachedUtil.getKeysForMap(memCachedClient);
		for(String key : keysForMap.keySet()) {
			System.out.println("--------------------------"+key);
		}
	}
	
	@Test
	public void testJson() {
		Object[] args = {1};
		System.out.println("-------------"+args);
		String json = JsonUtil.getInstance().obj2json(args);
		System.out.println(json);
	}
	
}
