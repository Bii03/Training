package readwriteobjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import serializablesupernonserializablesub.Student;

public class SerializeDeserializeObject<T> {

	private String fileName;


	public SerializeDeserializeObject(String fileName) {
		super();
		this.fileName = fileName;
	}

	public void serializeObject(T objectToSerialize) throws IOException {
		
		FileOutputStream fileOut = null;
		ObjectOutputStream out = null;

		try {
			fileOut = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fileOut);
			out.writeObject(objectToSerialize);
			System.out.println("Serialized data is saved in " + fileName);

		} finally {
			if (out != null) {
				out.close();
			}
			if (fileOut != null) {
				fileOut.close();
			}

		}

	}
	
	public T deserializeObject() throws IOException, ClassNotFoundException{
		FileInputStream fileIn = null;
		ObjectInputStream in = null;
		T objectToBeDeserialized = null;
		
		try{
			fileIn = new FileInputStream(fileName);
			in = new ObjectInputStream(fileIn);
			objectToBeDeserialized = (T)in.readObject();
			System.out.println(objectToBeDeserialized);
			return objectToBeDeserialized;
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
