package serializablesupersubclasses;

public class Student extends Person{
	
	private String degree;
	
	public Student(String firstName, String lastName, int age, String degree) {
		super(firstName, lastName, age);
		// TODO Auto-generated constructor stub
		this.degree = degree;
	}

	public String toString() {
		return super.toString()+"Student [degree=" + degree + "]";
	}
	
	
	

}
