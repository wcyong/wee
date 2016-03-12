package org.wcy.wee.demo.redis;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * 分片式集群的连接池
 * 
 * @author wcyong
 *
 */
public class ShardedJedisPoolDemo {

	public static void main(String[] args) {
		// 构建连接池配置信息
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		// 设置最大连接数
		jedisPoolConfig.setMaxTotal(50);

		// 定义集群信息
		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
		shards.add(new JedisShardInfo("192.168.1.240", 6379));
		// shards.add(new JedisShardInfo("192.168.1.241", 6379));

		// 定义集群连接池
		ShardedJedisPool shardedJedisPool = new ShardedJedisPool(jedisPoolConfig, shards);
		ShardedJedis shardedJedis = null;
		try {
			shardedJedis = shardedJedisPool.getResource();
			/*for (int i = 0; i < 100; i++) {
				shardedJedis.set("key_" + i, "value_" + i);
			}*/
			// 从redis中获取数据
			String value = shardedJedis.get("key_62");
			System.out.println(value);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != shardedJedis) {
				// 关闭，检测连接是否有效，有效则放回到连接池中，无效则重置状态
				shardedJedis.close();
			}
		}
		// 关闭连接池
		shardedJedisPool.close();
	}
}
