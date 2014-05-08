package colections.exercises;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableString implements Iterable<Character>, Iterator<Character> {

	private String stringObject;

	private int cursor;
	
	

	public IterableString(String stringObject) {
		super();
		this.stringObject = stringObject;
	}

	@Override
	public boolean hasNext() {
		if (cursor < stringObject.length())
			return true;
		return false;
	}

	@Override
	public Character next() {
		// TODO Auto-generated method stub
		if (cursor == stringObject.length())
			throw new NoSuchElementException();

		cursor++;
		return stringObject.charAt(cursor - 1);
	}
	
	 

	@Override
	public Iterator<Character> iterator() {
		// TODO Auto-generated method stub
		return this;
	}
	
	public static void main(String[] args) {
		IterableString iterableString = new IterableString("Iterating over the characters of a String object");
		
		for(char ch: iterableString){
			System.out.println(ch);
		}
		
	}

}
