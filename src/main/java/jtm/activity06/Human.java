package jtm.activity06;

public class Human implements Humanoid {

	String backpack = null;
	private int weight;
	public String alive = "Alive";

	public Human() {
		this.setWeight(this.weight = 42);
	}

	public Human(int weight) {
		this.setWeight(weight);
	}

	@Override
	public String toString() {
		return "Humanoid" + this.getWeight() + " [" + backpack + "]";
	}

	@Override
	public int getWeight() {
		return this.weight;
	}

	@Override
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String killHimself() {
		alive = "Dead";
		return alive;
	}

	@Override
	public int getArmCount() {

		return Humanoid.ARM_COUNT;
	}

	@Override
	public Object getBackpack() {

		return this.backpack;
	}

	@Override
	public void setBackpack(String item) {
		backpack = item;
	}

	@Override
	public String isAlive() {
		return alive;
	}

}
