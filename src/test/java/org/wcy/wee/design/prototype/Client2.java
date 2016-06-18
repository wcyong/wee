package org.wcy.wee.design.prototype;

import java.util.Date;

/**
 * 测试原型模式(深复制)
 * @author wcyong
 *
 */
public class Client2 {

	public static void main(String[] args) throws Exception {
		Date d = new Date(1234555L);
		Sheep s = new Sheep("xxx", d);
		System.out.println(s);
		System.out.println(s.getBirthday());
		
		
		Sheep s2 = (Sheep) s.clone();
		d.setTime(new Date().getTime());
		System.out.println(s2);
		System.out.println(s2.getSname());
		
		System.out.println(s.getBirthday());
		System.out.println(s2.getBirthday());
		
	}
}
