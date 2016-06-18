package org.wcy.wee.design.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandler implements InvocationHandler {

	Star realStar;
	
	public StarHandler(Star realStar) {
		this.realStar = realStar;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object object = null;
		
		System.out.println("真正的方法执行前");
		
		if(method.getName().equals("sing")) {
			object = method.invoke(realStar, args);
		}
		
		return object;
	}

}
