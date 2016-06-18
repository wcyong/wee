package org.wcy.wee.design.decorator;

public class Client {

	public static void main(String[] args) {
		Car car = new Car();
		car.move();
		
		System.out.println("-----------------");
		FlyCar fc = new FlyCar(car);
		fc.move();
		
		System.out.println("-----------------");

		WaterCar wc = new WaterCar(car);
		wc.move();
		
		System.out.println("-----------------");
		WaterCar wc2 = new WaterCar(fc);
		wc2.move();
	}
}
