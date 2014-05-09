
public class CustomThread implements Runnable{
	
	public static int currentID = 0;
	private int threadID;
	
	public CustomThread() {
		// TODO Auto-generated constructor stub
		threadID = currentID++;
	}

	public void run() {
		// TODO Auto-generated method stub
		int level = 0;
		
		while(level<10){
			System.out.println("Thread number "+threadID+" has reached level "+(level++));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	

}
