package colections.exercises;

import java.util.Map;
import java.util.TreeMap;

/**
 * Compile and run. What's the problem?
 * 
 * @author George Trandafir
 * 
 * Solution: Square should implement Comparable
 * 
 * Why: the ordering maintained by a tree map must be consistent with equals if 
 * this sorted map is to correctly implement the Map interface.
 * This is so because the Map interface is defined in terms of the equals operation, 
 * but a sorted map performs all key comparisons using its compareTo (or compare) method, 
 * so two keys that are deemed equal by this method are, from the standpoint of the sorted map, 
 * equal. The behavior of a sorted map is well-defined even if its ordering is inconsistent with equals; 
 * it just fails to obey the general contract of the Map interface.
 */
public class Ex4 {
	public static void main(String[] args) {
		House house1 = new House(1);
		House house2 = new House(50);
		Square square1 = new Square(20, 22);
		Square square2 = new Square(21, 23);
		Map<Square,House> map = new TreeMap<>();
		
		map.put(square1, house1);
		map.put(square2, house2);
		System.out.println(map.containsKey(square1));
		
		for (Square index : map.keySet()) {
			System.out.println(map.get(index));
		}
	}
}

class Square implements Comparable<Square>{
	private int xPos, yPos;

	public Square(int x, int y) {
		xPos = x;
		yPos = y;
	}

	@Override
	public int compareTo(Square squareObject) {
		// TODO Auto-generated method stub
		return this.xPos - squareObject.xPos;
	}

}


class House {
	private Integer age;

	public House(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "House [age=" + age + "]";
	}
}
