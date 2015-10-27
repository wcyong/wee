package org.wcy.wee.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Redis测试
 * @author wcyong
 *
 * @date   2015年10月27日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"/spring/applicationContext.xml", "/spring/redis.xml"})
public class RedisTest {
	
	@Autowired
	private ShardedJedisPool shardedJedisPool;
	
	@Test
	public void testSet() {
		ShardedJedis jedis = shardedJedisPool.getResource();
		jedis.set("age", "25");
	}
	
	@Test
	public void testGet() {
		ShardedJedis jedis = shardedJedisPool.getResource();
		String string = jedis.get("age");
		System.out.println(string);
	}
}
