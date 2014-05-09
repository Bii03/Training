package serializablesupersubclasses;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		String fileName = "student.txt";
		
		Person student = new Student("Bianca", "Tesila", 22, "Baccalaureate");
		FileOutputStream fileOut = null;
		ObjectOutputStream out = null;
		
		try{
			 fileOut = new FileOutputStream(fileName);
			 out = new ObjectOutputStream(fileOut);
			out.writeObject(student);
			System.out.println("Serialized data is saved in "+fileName);
		
		}catch(IOException e){
			throw e;
			
		}finally{
			if(out != null){
				out.close();
			}
			if(fileOut != null){
				fileOut.close();
			}
			
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		student = null;
		FileInputStream fileIn = null;
		ObjectInputStream in = null;
		
		try{
			fileIn = new FileInputStream(fileName);
			in = new ObjectInputStream(fileIn);
			student = (Student)in.readObject();
			System.out.println(student);
		}catch(IOException e){
			throw e;
		}catch(ClassNotFoundException e){
			throw e;
		}finally{
			if(in != null){
				in.close();
			}
			if(fileIn != null){
				fileIn.close();
			}
		}
		
		
	}
}
