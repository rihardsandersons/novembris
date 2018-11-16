package jtm.activity06;

public class Martian implements Humanoid, Cloneable, Alien {

	Object backpack;
	int weight;

	public Martian(int weight) {
		super();
		this.weight = weight;
	}

	@Override
	public void eatHuman(Humanoid humanoid) {
		if (humanoid.isAlive().equals("Alive")) {
			this.setWeight(getWeight() + humanoid.getWeight());
			humanoid.killHimself();
		}
	}

	@Override
	public int getLegCount() {
		return Martian.LEG_COUNT;
	}

	@Override
	public void setBackpack(Object item) {
		if (item != this && (item instanceof Martian || item instanceof Human || item instanceof String)) {
			backpack = item;
		}
	}

	@Override
	public int getWeight() {
		return weight;
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
		if (backpack instanceof String) {
			return new String((String) backpack);
		} else if (backpack instanceof Martian) {
			Martian martian = (Martian) backpack;
			Martian back = new Martian(martian.getWeight());
			back.setBackpack(martian.getBackpack());
			return back;
		} else if (backpack instanceof Human) {
			Human human = (Human) backpack;
			Human hum = new Human(human.getWeight());
			return hum;
		} else {
			return null;
		}
	}

	@Override
	public void setBackpack(String item) {
		backpack = item;
	}

	@Override
	public String isAlive() {
		return "I AM IMMORTAL!";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return clone(this);
	}

	private Object clone(Object current) {
		Martian martian = new Martian(((Martian) current).getWeight());
		martian.setBackpack(((Martian) current).getBackpack());
		return martian;
	}

	@Override
	public String toString() {
		return "Martian: " + weight + " [" + backpack + "]";
	}

}
