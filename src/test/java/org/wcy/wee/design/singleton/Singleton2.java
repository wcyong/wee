package org.wcy.wee.design.singleton;

/**
 * 懒汉式(单例对象延迟加载)
 * @author wcyong
 *
 */
public class Singleton2 {

	//类初始化时，不初始化这个对象（延时加载，真正用的时候再创建）
	private static Singleton2 s = null;
	
	private Singleton2() {}
	
	//方法同步，调用效率低
	public static synchronized Singleton2 getInstance() {
		if(s == null) {
			s = new Singleton2();
		}
		return s;
	}
	
	
}
