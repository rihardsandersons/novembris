/**
 * 
 */
package jtm.activity07;

/**
 * @author student
 *
 */
public class Animal {


	private int Age;


	public Animal() {
		// TODO Auto-generated constructor stub
	}


	public void setAge(int age) {
		if (age > 0) {
			this.Age = age;
		} else
			Age = 0;
	}

	public int getAge() {
		return Age;
	}

}
