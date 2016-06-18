package org.wcy.wee.design.singleton;

/**
 * 双重检测锁实现
 * 		由于 编译器优化原因和JVM底层内部模型原因，
 * 	偶尔会出问题，不建议使用
 * @author wcyong
 *
 */
public class Singleton3 {

	private static Singleton3 s = null;
	
	private Singleton3() {}
	
	public static Singleton3 getInstance() {
		if(s == null) {
			Singleton3 sc;
			synchronized (Singleton3.class) {
				sc = s;
				if(sc == null) {
					synchronized (Singleton3.class) {
						if(sc == null) {
							sc = new Singleton3();
						}
					}
					s = sc;
				}
			}
			
		}
		return s;
	}
	
}
