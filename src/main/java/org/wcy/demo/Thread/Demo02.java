package org.wcy.demo.Thread;

/**
 *  上一个例子（Demo01.java）通过一个简单的例子说明了线程安全与不安全，在例子中不安全的情况下输出的结果恰好是逐个
 *  递增的(其实是巧合，多运行几次，会产生不同的输出结果)，
 *  为什么会产生这样的结果呢，因为建立的Count对象是线程共享的，一个线程改变了其成员变量num值，下一个线程正巧读到了修改后的num，所以会递增输出。
 *  要说明线程同步问题首先要说明Java线程的两个特性，可见性和有序性。多个线程之间是不能直接传递数据交互的，它们之间的交互只能通过共享变量来实现。
*   拿上篇博文中的例子来说明，在多个线程之间共享了Count类的一个对象，这个对象是被创建在主内存(堆内存)中，每个线程都有自己的工作内存(线程栈)，
*   工作内存存储了主内存Count对象的一个副本，当线程操作Count对象时，首先从主内存复制Count对象到工作内存中，然后执行代码count.count()，
*   改变了num值，最后用工作内存Count刷新主内存Count。当一个对象在多个内存中都存在副本时，如果一个内存修改了共享变量，其它线程也应该能够看到被修改后的值，
*   此为可见性。
*   多个线程执行时，CPU对线程的调度是随机的，我们不知道当前程序被执行到哪步就切换到了下一个线程，一个最经典的例子就是银行汇款问题，
*   一个银行账户存款100，这时一个人从该账户取10元，同时另一个人向该账户汇10元，那么余额应该还是100。那么此时可能发生这种情况，A线程负责取款，
*   B线程负责汇款，A从主内存读到100，B从主内存读到100，A执行减10操作，并将数据刷新到主内存，这时主内存数据100-10=90，而B内存执行加10操作，
*   并将数据刷新到主内存，最后主内存数据100+10=110，显然这是一个严重的问题，我们要保证A线程和B线程有序执行，先取款后汇款或者先汇款后取款，此为有序性。
*   本文讲述了JDK5.0之前传统线程的同步方式，更高级的同步方式可参见Java线程(八)：锁对象Lock-同步问题更完美的处理方式。
*   下面同样用代码来展示一下线程同步问题。
 */
public class Demo02 {
	//创建两个线程，执行同一个对象的输出方法。
	public static void main(String[] args) {
		final Output output = new Output();
		
		new Thread() {
			public void run() {
				output.output("zhangsan");
			};
		}.start();
		
		new Thread() {
			public void run() {
				output.output("lisi");
			};
		}.start();
	}
}

/**
 * 显然输出的字符串被打乱了，我们期望的输出结果是zlhiasnigsan，这就是线程同步问题，
 * 我们希望output方法被一个线程完整的执行完之后再切换到下一个线程，
 * Java中使用synchronized保证一段代码在多线程执行时是互斥的，有两种用法：
 * 1. 使用synchronized将需要互斥的代码包含起来，并上一把锁。
 * 		这把锁必须是需要互斥的多个线程间的共享对象，像下面的代码是没有意义的。
 * 2. 将synchronized加在需要互斥的方法上。
 */
/*class Output {
	public void output(String name) {
		//为了保证对name的输出不是一个原子操作，这里逐个输出name的每个字符
		for(int i=0; i<name.length(); i++) {
			System.out.print(name.charAt(i));
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}*/

//方法一
/*class Output {
	public void output(String name) {
		//为了保证对name的输出不是一个原子操作，这里逐个输出name的每个字符
		synchronized (this) {
			for(int i=0; i<name.length(); i++) {
				System.out.print(name.charAt(i));
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}*/

//方法二
// 这种方式就相当于用this锁住整个方法内的代码块，如果用synchronized加在静态方法上，
//就相当于用××××.class锁住整个方法内的代码块。使用synchronized在某些情况下会造成死锁，死锁问题以后会说明。
//使用synchronized修饰的方法或者代码块可以看成是一个原子操作。
class Output {
	public synchronized void output(String name) {
		//为了保证对name的输出不是一个原子操作，这里逐个输出name的每个字符
		for(int i=0; i<name.length(); i++) {
			System.out.print(name.charAt(i));
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

