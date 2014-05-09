package serializablecircularlist;

import java.io.IOException;

import readwriteobjects.SerializeDeserializeObject;

public class TestCircularList {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		
		CircularList<Integer> circularList = new CircularList<>();
		
		for(int i=0; i<10; i++){
			circularList.add(i);
		}
		
		SerializeDeserializeObject utilObject = new SerializeDeserializeObject("list.txt");
		
		utilObject.serializeObject(circularList);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		utilObject.deserializeObject();
	}
}
