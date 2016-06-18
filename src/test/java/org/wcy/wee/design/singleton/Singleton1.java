package org.wcy.wee.design.singleton;

/**
 * 饿汉式（单例对象立即加载）
 * @author wcyong
 *
 */
public class Singleton1 {
	
	//类初始化时立即加载(没有延时加载的优势)，天然是线程安全的
	private static Singleton1 s = new Singleton1();
	
	private Singleton1() {}
	
	//方法没有同步，调用效率高
	public static Singleton1 getInstance() {
		return s;
	}
	
}

