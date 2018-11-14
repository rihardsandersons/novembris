package jtm.activity05;

import jtm.activity04.Transport;

public class Ship extends Transport {

	protected byte sails;

	public Ship(String id, float consumption, int tankSize, float fuelInTank,
			byte sails) {
		super(id, consumption, tankSize, fuelInTank);
		this.sails = sails;
		// TODO Auto-generated constructor stub

	}
	@Override
	public	String move(Road road) {
		if (road.getClass() == Road.class)
			return "tests" +super.move(Road);
		else
			
	}
	

}
