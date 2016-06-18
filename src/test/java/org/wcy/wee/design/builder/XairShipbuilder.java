package org.wcy.wee.design.builder;

public class XairShipbuilder implements AireShipBuild {

	@Override
	public Engine builderEngine() {
		System.out.println("xxxxxx");
		return new Engine("xx");
	}

	@Override
	public OrbitalModule builderOrbitalModule() {
		return new OrbitalModule("xxx");
	}

	@Override
	public EscapeTower builderEscapeTower() {
		return new EscapeTower("xxx");
	}

	
	
}
