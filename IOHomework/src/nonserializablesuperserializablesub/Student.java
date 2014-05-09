package nonserializablesuperserializablesub;

import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 * 
 * @author btesila
 *
 */

public class Student extends Person implements Serializable{
	
	private String degree;
	
	public Student(String firstName, String lastName, int age, String degree) {
		super(firstName, lastName, age);
		// TODO Auto-generated constructor stub
		this.degree = degree;
	}

	public String toString() {
		return super.toString()+"Student [degree=" + degree + "]";
	}
	
	

	
	

}
