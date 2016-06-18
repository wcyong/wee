package org.wcy.wee.design.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 测试鑫线程环境下5种创建单例模式的效率
 * @author wcyong
 *
 */
public class Client3 {

	public static void main(String[] args) throws Exception {
		
		long start = System.currentTimeMillis();
		
		int threadNum = 100;
		final CountDownLatch countDownLatch = new CountDownLatch(threadNum);
		
		for(int i=0; i<threadNum; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int i=0; i<100000; i++) {
						Object o = Singleton4.getInstance();
					}
					
					countDownLatch.countDown();
				}
			}).start();
		}
		
		//main阻塞，直到计数器变为0，才会继续往下执行
		countDownLatch.await();
		
		long end = System.currentTimeMillis();
		System.out.println("总耗时:" + (end-start));
		
	}
}
