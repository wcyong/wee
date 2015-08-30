package org.wcy.wee.demo.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 程序开始，A线程判断盘子是否为空，放入一个鸡蛋，并且唤醒在阻塞队列的一个线程，阻塞队列为空；
 * 假设CPU又调度了一个A线程，盘子非空，执行等待，这个A线程进入阻塞队列；然后一个B线程执行，盘子非空，取走鸡蛋，
 * 并唤醒阻塞队列的A线程，A线程进入就绪队列，此时就绪队列就一个A线程，马上执行，放入鸡蛋；如果再来A线程重复第一步，
 * 在来B线程重复第二步，整个过程就是生产者(A线程)生产鸡蛋，消费者(B线程)消费鸡蛋。
 *
 */
public class Demo03 {
	
	public static void main(String[] args) {
		Plate plate = new Plate();
		for(int i=0; i<10; i++) {
			new Thread(new AddThread(plate)).start();
			new Thread(new GetThread(plate)).start();
		}
	}
}

//定义一个盘子类，可以放鸡蛋和取鸡蛋
class Plate {
	List<Object> eggs = new ArrayList<Object>();
	
	//放鸡蛋
	public synchronized void putEgg(Object egg) {
		while(eggs.size() > 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		eggs.add(egg);//往盘子里放鸡蛋  
		notify();//唤醒阻塞队列的某线程到就绪队列  
		System.out.println("放入鸡蛋");
	}
	
	//取鸡蛋
	public synchronized Object getEgg() {
		while(eggs.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Object egg = eggs.get(0);
		eggs.clear();//清空盘子  
		notify();//唤醒阻塞队列的某线程到就绪队列 
		System.out.println("拿到鸡蛋");
		return egg;
	}
}

class AddThread implements Runnable {
	
	private Plate plate;
	Object egg = new Object();
	
	public AddThread(Plate plate) {
		this.plate = plate;
	}

	@Override
	public void run() {
		plate.putEgg(egg);
	}
	
}

class GetThread implements Runnable {
	
	private Plate plate;
	
	public GetThread(Plate plate) {
		this.plate = plate;
	}
	
	@Override
	public void run() {
		plate.getEgg();
	}
}
