package org.wcy.demo.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *	线程池 
 *
 *创建了一个固定大小的线程池，容量为3，然后循环执行了4个任务，由输出结果可以看到，前3个任务首先执行完，
 *然后空闲下来的线程去执行第4个任务，在FixedThreadPool中，有一个固定大小的池，如果当前需要执行的任务超过了池大小，那么多于的任务等待状态，直到有空闲下来的线程执行任务，而当执行的任务小于池大小，空闲的线程也不会去销毁。
 *
 *
 */

public class Demo06 {

	public static void main(String[] args) {
		//ExecutorService threadPool = Executors.newFixedThreadPool(3);//创建可以容纳3个线程的线程池  
		//ExecutorService threadPool = Executors.newCachedThreadPool();//线程池的大小会根据执行的任务数动态分配  
		ExecutorService threadPool = Executors.newSingleThreadExecutor();//创建单个线程的线程池，如果当前线程在执行任务时突然中断，则会创建一个新的线程替代它继续执
		for(int i=1; i<5; i++) {
			final int taskId = i;
			threadPool.execute(new Runnable() {
				public void run() {
					for(int i=0; i<5; i++) {
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("第" + taskId + "次任务的第" + i + "次执行");  
					}
				}
			});
		}
		threadPool.shutdown();
	}
}
