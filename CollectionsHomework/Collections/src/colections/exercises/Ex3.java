package colections.exercises;

import java.util.Iterator;

/**
 * Lets make our own iterable collection. We want to be able to write a
 * "foreach" on our collection. Solution?
 * 
 * @author George Trandafir
 * 
 * Solution: make Town implement Iterable
 */
public class Ex3 {
	public static void main(String[] args) {
		Town<String> myTown = new Town<String>();
		for (String town : myTown) {

		}
	}
}

class Town<T> implements Iterable<T>{
	private T type;

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}



}