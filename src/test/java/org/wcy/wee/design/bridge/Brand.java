package org.wcy.wee.design.bridge;

public interface Brand {

	public void sale();
	
}


class Lenovo implements Brand {

	@Override
	public void sale() {
		System.out.println("销售联想电脑");
	}
	
}

class Dell implements Brand {

	@Override
	public void sale() {
		System.out.println("销售戴尔电脑");
	}
	
}