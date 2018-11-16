package jtm.activity05;

import jtm.activity04.Road;

public class WaterRoad extends Road {

	public WaterRoad(String from, String to, int distance) {
		super(from, to, distance);
	}

	@Override
	public String toString() {
		return "WaterRoad " + getFrom() + " — " + getTo() + ", " + getDistance() + "km";
	}

	public WaterRoad() {
	}

}
