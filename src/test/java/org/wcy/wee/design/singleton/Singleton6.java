package org.wcy.wee.design.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 饿汉式（如何防止反射和反序列化漏洞）
 * @author wcyong
 *
 */
public class Singleton6 implements Serializable {
	
	//类初始化时，不初始化这个对象（延时加载，真正用的时候再创建）
	private static Singleton6 s = null;
	
	private Singleton6() {
		if(s != null) {//防止反射破解
			throw new RuntimeException();
		}
		
	}
	
	//方法同步，调用效率低
	public static synchronized Singleton6 getInstance() {
		if(s == null) {
			s = new Singleton6();
		}
		return s;
	}
	
	//防止反序列化破解
	//如果定义了readResolve方法，则直接返回此方法指定的对象，而不需要单独再创建
	private Object readResolve() throws ObjectStreamException {
		return s;
	}
	
}

