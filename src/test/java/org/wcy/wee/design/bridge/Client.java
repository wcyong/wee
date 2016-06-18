package org.wcy.wee.design.bridge;

public class Client {

	public static void main(String[] args) {
		//销售联想笔记本电脑
		Computer2 c = new Laptop2(new Lenovo());
		c.sale();
		
		Computer2 c2 = new Desktop2(new Lenovo());
		c2.sale();
		
	}
}
