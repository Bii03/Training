package domain;

import java.util.Date;

public class Employee {
	private String name;
	private Date birthdate;
	private double salary;
	private int department;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", birthdate=" + birthdate
				+ ", salary=" + salary + ", department=" + department + "]";
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getDepartment() {
		return department;
	}
	public void setDepartment(int department) {
		this.department = department;
	}
	
	
}
