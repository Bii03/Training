package serializablesupernonserializablesub;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import readwriteobjects.SerializeDeserializeObject;

public class TestNonSerializableSubclass {
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		SerializeDeserializeObject utilObject = new SerializeDeserializeObject("student.txt");
		
		Person student = new Student("Bianca", "Tesila", 22, "Baccalaureate");
		
		utilObject.serializeObject(student);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		utilObject.deserializeObject();

		
		
		
	}
}
