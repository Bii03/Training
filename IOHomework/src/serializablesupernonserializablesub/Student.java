package serializablesupernonserializablesub;

import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * Student is not serializable - overridden writeObject and readObject()
 * @author btesila
 *
 */

public class Student extends Person{
	
	private String degree;
	
	public Student(String firstName, String lastName, int age, String degree) {
		super(firstName, lastName, age);
		// TODO Auto-generated constructor stub
		this.degree = degree;
	}

	public String toString() {
		return super.toString()+"Student [degree=" + degree + "]";
	}
	
	
	private void writeObject(ObjectOutputStream oos) throws NotSerializableException{
		throw new NotSerializableException();
	}
	
	private void readObject(ObjectInputStream ois) throws NotSerializableException{
		throw new NotSerializableException();
	}
	
	

}
