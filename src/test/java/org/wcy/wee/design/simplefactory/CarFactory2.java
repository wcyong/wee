package org.wcy.wee.design.simplefactory;

/**
 * 简单工厂(也叫静态工厂模式)
 * 		增加新的子类，要修改已有的代码，无法扩展
 * 		违背OCP原则
 * @author wcyong
 *
 */
public class CarFactory2 {

	public static Car createAudi() {
		return new Audi();
	}
	
	public static Car createByd() {
		return new Byd();
	}
	
}
