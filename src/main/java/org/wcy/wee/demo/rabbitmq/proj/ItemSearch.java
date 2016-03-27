package org.wcy.wee.demo.rabbitmq.proj;

/**
 * 消费者
 * @author wcyong
 *
 */
public class ItemSearch {

	public void listen(String foo) {
		System.out.println("ItemSearch： " + foo);
	}
}
