package org.wcy.wee.design.abstractfactory;

public interface Tyre {

	public void revolve();
	
}

class LuxuryTyre implements Tyre {

	@Override
	public void revolve() {
		System.out.println("旋转不磨损");
	}
	
}

class LowTyre implements Tyre {

	@Override
	public void revolve() {
		System.out.println("磨损快");
	}
	
}
