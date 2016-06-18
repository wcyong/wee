package org.wcy.wee.testnexted;

import org.wcy.wee.testnexted.Outer02.StaticInnerClass;

public class Demo02 {

	public static void main(String[] args) {
		//Outer02.StaticInnerClass osic = new Outer02.StaticInnerClass();
		StaticInnerClass osic = new StaticInnerClass();
	}
	
}

class Outer02 {
	int c = 5;
	static int d = 10;
	
	//静态内部类
	/*private*/ static class StaticInnerClass {
		int a = 3;
		static int b = 5;
		
		public void test() {
			//静态内部类中不能调用外部类的普通成员
			//只能调用静态成员
			System.out.println(d);
		}
	}
	
	void t() {
		StaticInnerClass sic = new StaticInnerClass();
		sic.test();
	}
}
