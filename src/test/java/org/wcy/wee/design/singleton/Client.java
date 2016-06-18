package org.wcy.wee.design.singleton;

public class Client {

	public static void main(String[] args) {
		Singleton1 s1 = Singleton1.getInstance();
		Singleton1 s2 = Singleton1.getInstance();
		System.out.println(s1);
		System.out.println(s2);
		
		
		Singleton5 s51 = Singleton5.INSTANCE;
		Singleton5 s52 = Singleton5.INSTANCE;
		System.out.println(s51);
		System.out.println(s52);
	}
}
