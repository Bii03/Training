package colections.exercises;

import java.util.Set;
import java.util.TreeSet;

/**
 * Compile and run. What's the problem?
 * 
 * @author George Trandafir
 * 
 * Life changing: http://stackoverflow.com/questions/17027139/access-private-field-of-another-object-in-same-class
 */
public class Ex1 {
	public static void main(String[] args) {
		Graduate graduate1 = new Graduate(1);
		Graduate graduate2 = new Graduate(2);

		//A TreeSet needs to keep its elements sorted, thus Graduate should implement Comparable in order to be able to 
		//compare instances of Graduate.
		Set<Graduate> set = new TreeSet<>();
		set.add(graduate1);
		set.add(graduate2);
		for (Graduate graduate : set) {
			System.out.println(graduate);
		}
	}
}

class Graduate implements Comparable<Graduate>{
	private Integer age;

	public Graduate(Integer age) {
		this.age = age;
	}
	
	public Integer getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Graduate [age=" + age + "]";
	}

	@Override
	public int compareTo(Graduate graduateObject) {
		
		//Why is this working without a getter?!
		//return this.age - graduateObject.age;
		
		return this.age - graduateObject.getAge();
	}

	
}
