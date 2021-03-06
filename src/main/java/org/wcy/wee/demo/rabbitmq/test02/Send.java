package org.wcy.wee.demo.rabbitmq.test02;

import org.wcy.wee.demo.rabbitmq.util.ConnectionUtil;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * work模式，一个消息，只能被一个消费都消费
 * 
 * @author wcyong
 *
 */
public class Send {

	private static final String QUEUE_NAME = "test_queue_work";

	public static void main(String[] args) throws Exception {
		// 获取到连接以及mq通道
		Connection connection = ConnectionUtil.getConnection();
		Channel channel = connection.createChannel();

		// 声明队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);

		for (int i = 0; i < 100; i++) {
			// 消息内容
			String message = "" + i;
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			System.out.println(" [x] Sent '" + message + "'");
			Thread.sleep(i * 10);
		}

		channel.close();
		connection.close();

	}
}
