/**
 * 
 */
package jtm.activity07;

/**
 * @author student
 *
 */
public class Dog extends Mammal {

	/**
	 * 
	 */
	private java.lang.String name;

	public Dog() {
	}

	public void setName(String name) {
		if (Character.isUpperCase(name.charAt(0)) && name.chars().allMatch(Character::isLetter)) {
			this.name = name;
		} else
			this.name = "";

	}

	public java.lang.String getName() {
		return this.name;
	}

}
