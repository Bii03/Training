package colections.exercises;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Run the example? What happens? Why?
 * @author gtrandafir
 *
 * Problem: MyInteger neither implements Comparable, nor a Comparator is given as a parameter for the 
 * PriorityQueue constructor
 * 
 * Why should it implement Comparable: The elements of the priority queue
 * are ordered according to their natural ordering, or by a Comparator provided at queue construction time.
 * Thus, A priority queue relying on natural ordering also does not permit insertion of non-comparable 
 * objects (doing so may result in ClassCastException)
 * 
 * Solution: This time, I have chosen to give a Comparator to the PriorityQueue constructor
 */
public class Ex5 {
	public static void main(String[] args){
		Queue<MyInteger> queue = new PriorityQueue<>(new Comparator<MyInteger>() {

			@Override
			public int compare(MyInteger arg0, MyInteger arg1) {
				// TODO Auto-generated method stub
				return arg0.getValue() - arg1.getValue();
			}
		});
		queue.add(new MyInteger(1));
		queue.add(new MyInteger(2));
		for (MyInteger myInteger : queue) {
			System.out.println(myInteger);
		}
		
	}
}

class MyInteger{
	private int value; 
	
	public MyInteger(int value) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "MyInteger [value=" + value + "]";
	}
}
