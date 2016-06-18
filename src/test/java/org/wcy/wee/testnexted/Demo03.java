package org.wcy.wee.testnexted;

import java.util.Date;

public class Demo03 {

	private int a = 100;
	int b = 20;
	
	
	//成员内部类
	class InnerClass {
		//成员内部类不能有静态成员,除非声明为final,并且只能是编译器可以确定的常量表达式
		//static int d = 10;
		final static int d = 10;
		//final static Date d2 = new Date();
		
		//成员内部类不能有静态方法
		void test() {
			System.out.println(a);
			//成员内部类对象的创建，必须先有外部类对象
			System.out.println(b) ;
		}
	}
	
}
