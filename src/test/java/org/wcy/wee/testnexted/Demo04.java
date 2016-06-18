package org.wcy.wee.testnexted;

/**
 * 测试方法内部类(局部内部类)
 * @author wcyong
 *
 */
public class Demo04 {

	public void test() {
		final int a = 10;
		
		class Inner {
			//方法内部只能定义非静态的成员
			int b = 20;
			
			void innert() {
				//方法内部类中不能引用所在方法的普通局部变量，除非是final
				System.out.println(a);
			}
		}
		
		Inner i = new Inner();
	}
	
	void test2() {
		
	}
	
	
}
