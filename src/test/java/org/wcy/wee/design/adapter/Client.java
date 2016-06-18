package org.wcy.wee.design.adapter;

public class Client {

	public static void main(String[] args) {
		Adptee t = new Adptee();
		
		Target a = new Adapter(t);
		
		a.handlerReq();
	}
}
