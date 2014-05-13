package randomlistwithoutchunks;

import java.util.List;

public class ListThread implements Runnable{

	private List<Integer> randomList;
	private List<Integer> primeList;
	private int threadID;
	public static int currentID;
	
	//This is used for knowing from where the thread should read further from the list
	private static int currentListOffset = 0;
	
	public ListThread(List<Integer> randomList, List<Integer> primeList){
		this.randomList = randomList;
		this.primeList = primeList;
		this.threadID = currentID++;
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(currentListOffset < randomList.size()){
			
			int currentElement = -1;
			
			//This time I need to synchronize on the input list in order to make sure that 
			//two threads do not read the same element at the same time
			synchronized (randomList) {
				currentElement = randomList.get(currentListOffset++);
			}

			if(currentElement != -1 && isPrime(currentElement)){
				
				//Obviously, I also need to synchronize on the output list to make sure that two threads do not write
				// to the list at the same time
				synchronized(primeList){
					primeList.add(currentElement);
					System.out.println("Thread "+this.threadID+" has added to prime list "+currentElement);
				}
				
			}

		}
	}
	
	public static boolean isPrime(int number){
		for (int i = 2; i <= number/2; i++)
            if (number % i == 0)
                return false;

        return true;
	}

}
