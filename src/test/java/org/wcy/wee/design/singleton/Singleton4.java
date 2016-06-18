package org.wcy.wee.design.singleton;

/**
 * 静态内部类实现方式（也是一种懒加载方式）
 * 		兼备了并发高效调用和延迟加载的优势
 * @author wcyong
 *
 */
public class Singleton4 {

	private Singleton4() {}
	
	//只有真正调用getInstance，才会加载静态内部类,加载类时是线程安全的
	private static class SingletonClassInstance {
		private static final Singleton4 instance = new Singleton4();
	}

	public static Singleton4 getInstance() {
		return SingletonClassInstance.instance;
	}
	
}
