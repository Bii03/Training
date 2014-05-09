import java.util.ArrayList;
import java.util.List;


public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		List<Thread> threads = new ArrayList<>();
		
		for(int i=0; i<10; i++){
			threads.add(new Thread(new CustomThread()));
			threads.get(i).start();
		}
		
		
		//This is not busy waiting
		for(Thread t:threads){
			t.join();
			System.out.println("another one bites the dust");
		}
		
		
		
		
		
		
	}
}
