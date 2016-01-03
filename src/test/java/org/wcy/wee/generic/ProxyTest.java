package org.wcy.wee.generic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;

public class ProxyTest {

	public static void main(String[] args) {
		Class proxyClass = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
		String name = proxyClass.getSimpleName();
		System.out.println(name);
		Constructor[] constructors = proxyClass.getConstructors();
		StringBuffer sb = new StringBuffer(name);
		for(Constructor constructor : constructors) {
			System.out.println(constructor);
		}
		
		Method[] methods = proxyClass.getMethods();
		for(Method m : methods) {
			System.out.println(m);
		}
	}
}
