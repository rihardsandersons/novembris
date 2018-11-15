package jtm.activity06;

public class Martian implements Humanoid, Cloneable, Alien {

	Object backpack;
	int weight;

	public Martian(int weight) {
		this.setWeight(this.weight = weight);
	}

	/*
	 * Implementation of Object clone() method for Cloneable interface
	 * 
	 * @see https://docs.oracle.com/javase/7/docs/api/java/lang/Cloneable.html
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return clone(this);
	}

	private Object clone(Object current) {
		// TODO implement cloning of current object
		// and its backpack
		return clone(current);
	}

	@Override
	public String toString() {
		return "ClassName: " + this.getClass() + this.getWeight() + " ["
				+ backpack + "]";
	}

	@Override
	public void eatHuman(Humanoid humanoid) {
		if (humanoid.isAlive().equals("Alive")) {
			humanoid.killHimself();
			this.setWeight(weight + humanoid.getWeight());
		}
	}

	@Override
	public int getLegCount() {
		return Martian.LEG_COUNT;
	}

	@Override
	public void setBackpack(Object item) {
		if (item != this) {
			backpack = item;
		}
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
		return "I AM IMMORTAL!";
	}

	@Override
	public int getArmCount() {
		return Martian.ARM_COUNT;
	}

	@Override
	public Object getBackpack() {
		return null;
	}

	@Override
	public void setBackpack(String item) {
	}

	@Override
	public String isAlive() {
		return "I AM IMMORTAL!";
	}

}
