package org.wcy.demo.Thread;

/**
 * 测试，我们发现，存在成员变量的类用于多线程时是不安全的，不安全体现在这个成员变量可能发生非原子性的操作，
 * 而变量定义在方法内也就是局部变量是线程安全的。
 * 想想在使用struts1时，不推荐创建成员变量，因为action是单例的，
 * 如果创建了成员变量，就会存在线程不安全的隐患，而struts2是每一次请求都会创建一个action，
 * 就不用考虑线程安全的问题。所以，日常开发中，通常需要考虑成员变量或者说全局变量在多线程环境下，是否会引发一些问题。
 */
public class Demo01 {

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			Count c = new Count();
			@Override
			public void run() {
				c.count();
			}
		};
		for(int i=0; i<10; i++) {
			new Thread(runnable).start();
		}
	}
}

class Count {
	//当num作为成员变量时，会存在问题，最后计算的值不正确
	//解决方法就是将成员变量改为局部变量
	//private int num;
	public void count() {
		int num = 0;
		for(int i=0; i<10; i++) {
			num+=i;
		}
		System.out.println(Thread.currentThread().getName()+"---------"+num);
	}
}
