package org.wcy.wee.design.prototype;

import java.util.Date;

/**
 * 测试原型模式(浅克隆)
 * @author wcyong
 *
 */
public class Client {

	public static void main(String[] args) throws Exception {
		Sheep s = new Sheep("xxx", new Date(1234555L));
		System.out.println(s);
		System.out.println(s.getSname());
		
		s.setSname("yyyyy");
		
		Sheep s2 = (Sheep) s.clone();
		System.out.println(s2);
		System.out.println(s2.getSname());
		
		s2.setSname("ooooo");
		System.out.println(s.getSname());
		System.out.println(s2.getSname());
	}
}
