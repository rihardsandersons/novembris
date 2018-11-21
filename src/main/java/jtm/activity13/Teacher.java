package jtm.activity13;

public class Teacher {

	private int id;
	private String firstName;
	private String lastName;

	// process passed values

	public Teacher(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getID() {

		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	// Override toString() method which returns teacher in form "Name Surname"
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
