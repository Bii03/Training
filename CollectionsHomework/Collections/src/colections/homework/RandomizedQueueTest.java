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


	    System.out.println("Testing the iterator:");
	    
	    Iterator<Integer> I= randomizedQueue.iterator();
        Iterator<Integer> J= randomizedQueue.iterator();
        
        while(I.hasNext()){
        	System.out.println(I.next());
        }
        System.out.println();
        System.out.println();
        System.out.println();
        
        while(J.hasNext()){
        	System.out.println(J.next());
        }
	}
	
}
