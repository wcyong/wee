package org.wcy.demo.rocketmq;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

public class Producer {

	public static void main(String[] args) {
		
		DefaultMQProducer producer = new DefaultMQProducer("Producer");
		producer.setNamesrvAddr("192.168.1.254:9876");
		try {
			producer.start();
			
			Message msg = new Message("PushTopic", "push", "1", "Just for test.".getBytes());
			SendResult result = producer.send(msg);
			System.out.println("id:"+result.getMsgId()+"---result:"+result.getSendStatus());
			
			msg = new Message("PushTopic", "push", "2", "Just for test.".getBytes());
			result = producer.send(msg);
			System.out.println("id:"+result.getMsgId()+"---result:"+result.getSendStatus());
			
			msg = new Message("PullTopic", "pull", "1", "Just for test.".getBytes());
			result = producer.send(msg);
			System.out.println("id:"+result.getMsgId()+"---result:"+result.getSendStatus());
			
		} catch (MQClientException e) {
			e.printStackTrace();
		} catch (RemotingException e) {
			e.printStackTrace();
		} catch (MQBrokerException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			producer.shutdown();
		}
		
	}
}
