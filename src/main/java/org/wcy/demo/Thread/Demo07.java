package org.wcy.demo.Thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *	线程池 
 *
 */

public class Demo07 {

	public static void main(String[] args) {
		//ScheduledThreadPool可以定时的或延时的执行任务。
		ScheduledExecutorService schedulepool = Executors.newScheduledThreadPool(1);
		
		//5秒后执行任务
		schedulepool.schedule(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("爆炸"); 
			}
		}, 5, TimeUnit.SECONDS);
		
		//5秒后执行任务，以后每2秒执行一次 
		schedulepool.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				System.out.println("爆炸11");  
			}
		}, 5, 2, TimeUnit.SECONDS);
	}
}
