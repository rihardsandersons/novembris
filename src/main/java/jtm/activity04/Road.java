package jtm.activity04;

public class Road {
	public Road(String from, String to, int distance) {
		super();
		this.from = from;
		this.to = to;
		this.distance = distance;
	}

	private String from; // Start point
	private String to; // End point
	private int distance; // distance in km

	public Road() {
		from = null;
		to = null;
		distance = 0;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return from + " — " + to + ", " + distance + "km";
	}
}
