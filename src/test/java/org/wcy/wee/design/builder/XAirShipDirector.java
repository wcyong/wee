package org.wcy.wee.design.builder;

public class XAirShipDirector implements AirShipDirector {

	private AireShipBuild builer;
	
	public XAirShipDirector(AireShipBuild builer) {
		this.builer = builer;
	}
	
	@Override
	public AirShip directorAirShip() {
		Engine e = builer.builderEngine();
		OrbitalModule o = builer.builderOrbitalModule();
		EscapeTower et = builer.builderEscapeTower();
		
		AirShip airShip = new AirShip();
		airShip.setEngine(e);
		airShip.setOrbitalModule(o);
		airShip.setEscapeTower(et);
		
		return airShip;
	}

}
