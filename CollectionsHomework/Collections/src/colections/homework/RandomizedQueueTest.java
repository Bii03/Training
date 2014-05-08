package colections.homework;

import java.util.Iterator;

public class RandomizedQueueTest {
	
	
	public static void main(String[] args) {
		
	    
		RandomizedQueue<Integer>  randomizedQueue = new RandomizedQueue<>();
	    
		for (int i = 1; i < 12; ++i) 
	    	randomizedQueue.enqueue(i); 


	    System.out.print("Testing sample: ");
	    for (int i = 1; i < 30; ++i) 
	    	System.out.print(randomizedQueue.sample() +" ");
	   
	    System.out.println();
	    System.out.println();
	    System.out.println();


	    System.out.println("Testing the iterator:");
	    Iterator<Integer> firstIterator= randomizedQueue.iterator();
        Iterator<Integer> secondIterator= randomizedQueue.iterator();
        
        while(firstIterator.hasNext()){
        	System.out.println(firstIterator.next());
        }
        System.out.println();
        System.out.println();
        System.out.println();
        
        while(secondIterator.hasNext()){
        	System.out.println(secondIterator.next());
        }
        
        
        System.out.println();
        System.out.println();
        System.out.println();
       
        
        System.out.println("Testing deque:");
        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());  
        Iterator<Integer> thirdIterator = randomizedQueue.iterator();
        System.out.println();
        
        while(thirdIterator.hasNext()){
        	System.out.println(thirdIterator.next());
        }
        
	}
	
}
