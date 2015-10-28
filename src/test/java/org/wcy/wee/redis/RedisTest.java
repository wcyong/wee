package org.wcy.wee.redis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Redis测试
 * 
 * @author wcyong
 *
 * @date 2015年10月27日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = { "/spring/applicationContext.xml", "/spring/redis.xml" })
public class RedisTest {

	@Autowired
	private ShardedJedisPool shardedJedisPool;

	ShardedJedis jedis = null;

	@Before
	public void setUp() {
		jedis = shardedJedisPool.getResource();
	}

	@Test
	public void testSet() {
		jedis.set("age", "25");
	}

	@Test
	public void testGet() {
		String string = jedis.get("age");
		System.out.println(string);
	}

	@Test
	public void testKeys() {
	}

}
