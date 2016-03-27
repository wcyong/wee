package org.wcy.wee.demo.rabbitmq.test05;

import org.wcy.wee.demo.rabbitmq.util.ConnectionUtil;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 通配符模式
 * 
 * @author wcyong
 *
 */
public class Send {
	
	private final static String EXCHANGE_NAME = "test_exchange_topic";

	public static void main(String[] args) throws Exception {
		 // 获取到连接以及mq通道
		Connection connection = ConnectionUtil.getConnection();
		Channel channel = connection.createChannel();
		
		 // 声明exchange
		channel.exchangeDeclare(EXCHANGE_NAME, "topic");
		
		// 消息内容
		String message = "Hello World";
		channel.basicPublish(EXCHANGE_NAME, "b.1", null, message.getBytes());
		System.out.println(" [x] Sent '" + message + "'");
		
		channel.close();
		connection.close();
		
	}
}
