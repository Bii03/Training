package persistence;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.Employee;


public class EmployeeDAO {
	
	static Connection connect = null;
	static Statement statement = null;
	static PreparedStatement preparedStatement = null;
	static ResultSet resultSet = null;
	
	public static List<Employee> getAllEmployees() throws Exception {
	    try {
	    	// this will load the MySQL driver, each DB has its own driver
	        Class.forName("com.mysql.jdbc.Driver");
	      connect = DriverManager
	          .getConnection("jdbc:mysql://localhost:3306/ex2", "root", "password");

	      // statements allow to issue SQL queries to the database
	      statement = connect.createStatement();
	      // resultSet gets the result of the SQL query
	      resultSet = statement
	          .executeQuery("select * from ex2.salariat");
	      
	      List<Employee> allEmployees = new ArrayList<Employee>();
	      
	      if (connect != null) {
	    	  System.out.println("You made it, take control your database now!");
	    	 } else {
	    	  System.out.println("Failed to make connection!");
	    	 }
	      
	      while (resultSet.next()) {
	    	  Employee employee = new Employee();
	    	  employee.setName(resultSet.getString("Nume"));
		      employee.setBirthdate(resultSet.getDate("DataNastere"));
		      employee.setSalary(resultSet.getDouble("Salariu"));
		      employee.setDepartment(resultSet.getInt("Departament_idDepartament"));
		      allEmployees.add(employee);
	      }
	      
	      return allEmployees;
	      
	    } catch (Exception e) {
	      throw e;
	    } finally {
	    	try {
	    		if(resultSet != null){
	    			resultSet.close();
	    		}
	    		
	    		if(statement != null){
	    			statement.close();
	    		}
	    		
	    		if(connect != null){
	    			connect.close();
	    		}
	    		
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	      
	    }

	  }
	
	
	 
}
