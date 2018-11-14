package jtm.activity05;

import jtm.activity04.Road;

public class WaterRoad extends Road {

	public WaterRoad(String from, String to, int distance) {
		super(from, to, distance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub WaterRoad From — To, 00km
		return "WaterRoad " + getFrom() + " — " + getTo() + ", "
				+ getDistance() + "km";
	}

	public WaterRoad() {
		// TODO Auto-generated constructor stub
	}

}
