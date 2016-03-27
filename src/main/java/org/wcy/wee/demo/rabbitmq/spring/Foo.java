package org.wcy.wee.demo.rabbitmq.spring;

/**
 * 消费者
 * @author wcyong
 *
 */
public class Foo {

	public void listen(String foo) {
		System.out.println("消费者： " + foo);
	}
}
