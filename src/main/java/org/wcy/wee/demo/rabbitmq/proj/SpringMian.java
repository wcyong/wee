package org.wcy.wee.demo.rabbitmq.proj;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMian {

	public static void main(String[] args) throws Exception {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/rabbitmq-context-topic.xml");
		// RabbitMQ模板
		RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
		// 发送消息
		template.convertAndSend("item.add", "99999");
		// 休眠1秒
		Thread.sleep(1000);
		// 容器销毁
		ctx.destroy();
	}
}
