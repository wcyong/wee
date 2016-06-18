package org.wcy.wee.testnexted;

public class Demo05 {

	public static void main(String[] args) {
		Outer05 out = new Outer05();
		out.test();
	}
}


class Outer05 {
	
	public void test() {
		
		//匿名内部类(接口式写法),同时也是方法内部类
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				
			}
		};
		
		//匿名内部类，继承式的写法
		Car car = new Car() {
			@Override
			public void run() {
				System.out.println("sub car run");
			}
		};
		car.run();
		
		test02(new Car(){
			@Override
			public void run() {
				System.out.println("xxxxxxx");
			}
		});
	}
	
	public void test02(Car car) {
		car.run();
	}
	
	
	
}

class Car {
	
	public void run() {
		System.out.println("car run");
	}
	
}