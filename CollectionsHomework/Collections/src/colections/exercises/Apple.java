package colections.exercises;

/**
 * A common mistake when working with HashMap
 * The idea behind a Map is to be able to find an object faster than a linear search. 
 * Using hashed keys to locate objects is a two-step process. 
 * Internally the Map stores objects as an array of arrays. 
 * The index for the first array is the hashcode() value of the key. 
 * This locates the second array which is searched linearly by using equals() to determine if the object is found.
 * 
 * Override hashCode() as well
 */

import java.util.HashMap;

public class Apple {
	private String color;
	 
	public Apple(String color) {
		this.color = color;
	}
 
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Apple))
			return false;	
		if (obj == this)
			return true;
		return this.color.equals(((Apple) obj).color);
	}
	
	@Override
	public int hashCode(){
		return this.color.length();	
	}
 
	public static void main(String[] args) {
		Apple a1 = new Apple("green");
		Apple a2 = new Apple("red");
 
		//hashMap stores apple type and its quantity
		HashMap<Apple, Integer> m = new HashMap<Apple, Integer>();
		m.put(a1, 10);
		m.put(a2, 20);
		
		//Without overriding hashCode(), this returns null, even though we have put a1 and (new Apple("green")).equals(a1) returns true
		//Why? Because the object is located using the hashCode of its key, which, in this case, is a different one from a1's hashCode
		System.out.println(m.get(new Apple("green")));
	}
}
