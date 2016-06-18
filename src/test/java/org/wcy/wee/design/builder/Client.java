package org.wcy.wee.design.builder;

public class Client {

	public static void main(String[] args) {
		AirShipDirector director = new XAirShipDirector(new XairShipbuilder());
		
		AirShip directorAirShip = director.directorAirShip();
		Engine engine = directorAirShip.getEngine();
		System.out.println(engine.getName());
	}
}
