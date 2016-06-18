package org.wcy.wee.design.abstractfactory;

public interface CarFactory {

	public Engine createEngine();
	public Seat createSeat();
	public Tyre createTyre();
}

