package org.wcy.wee.demo.rabbitmq.proj;

/**
 * 消费者
 * @author wcyong
 *
 */
public class ItemWeb {

	public void listen(String foo) {
		System.out.println("ItemWeb： " + foo);
	}
}
