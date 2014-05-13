package randomlistchunks;

import java.util.List;

public class ListThread implements Runnable{
	
	private List<Integer> randomList;
	private List<Integer> primeList;
	private int startOffset;
	private int endOffset;
	private int threadID;
	public static int currentID;
	
	public List<Integer> getRandomList() {
		return randomList;
	}

	public void setRandomList(List<Integer> randomList) {
		this.randomList = randomList;
	}

	public List<Integer> getPrimeList() {
		return primeList;
	}

	public void setPrimeList(List<Integer> primeList) {
		this.primeList = primeList;
	}

	public int getStartOffset() {
		return startOffset;
	}

	public void setStartOffset(int startOffset) {
		this.startOffset = startOffset;
	}

	public int getEndOffset() {
		return endOffset;
	}

	public void setEndOffset(int endOffset) {
		this.endOffset = endOffset;
	}


	public int getThreadID() {
		return threadID;
	}

	public void setThreadID(int threadID) {
		this.threadID = threadID;
	}

	public static int getCurrentID() {
		return currentID;
	}

	public static void setCurrentID(int currentID) {
		ListThread.currentID = currentID;
	}

	public static boolean isPrime(int number){
		for (int i = 2; i <= number/2; i++)
            if (number % i == 0)
                return false;

        return true;
	}
	
	public ListThread(List<Integer> randomList, List<Integer> primeList, int startOffset, int endOffset) {
		// TODO Auto-generated constructor stub
		this.randomList = randomList;
		this.primeList = primeList;
		this.startOffset = startOffset;
		this.endOffset = endOffset;
		this.threadID = currentID++;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

			for(int i=startOffset; i<endOffset; i++){
				int currentElement = randomList.get(i);
				if(isPrime(currentElement)){
					
					//I only need to synchronize when I write the prime numbers since I am sure that by using chunks,
					//no thread will read the same element as another one => no need to synchronize on randomList
					synchronized(primeList){
						primeList.add(currentElement);
						System.out.println("Thread "+this.threadID+" has added to prime list "+currentElement);
					}
					
				}

			}

		
		
	}

}
