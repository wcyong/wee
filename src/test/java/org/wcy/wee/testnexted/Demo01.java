package org.wcy.wee.testnexted;

public class Demo01 {

	
	//静态内部类
	private static class StaticNextedClass {
		
	}
	
	//普通内部类（成员内部类）
	private class FieldInnerClass {
		
	}
	
	void sayHello() {
		//方法内部类（局部内部类）
		class LocalClass {
			
		}
		
		//匿名内部类
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				
			}
		};
	}
	
}
