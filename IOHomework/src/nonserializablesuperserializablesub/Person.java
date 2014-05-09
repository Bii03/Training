package nonserializablesuperserializablesub;

import java.io.Serializable;

/**
 * Person is not Serializable. However, its subclass, Student, is and in order to not
 * throw exceptions at deserialization, InvalidClassException, Person should have a no-arg
 * constructor.
 * 
 * The no-arg constructor of Person is called at the deserialization of the Student object
 * 
 * @author btesila
 *
 */

public class Person{
	
	private String firstName;
	private String lastName;
	private int age;
	
	
	public Person(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + "]";
	}
	
	
	

}
