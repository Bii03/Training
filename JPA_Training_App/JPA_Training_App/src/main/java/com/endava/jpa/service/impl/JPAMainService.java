package com.endava.jpa.service.impl;

import com.endava.jpa.model.Department;
import com.endava.jpa.service.DepartmentService;
import com.endava.jpa.service.EmployeeService;
import com.endava.jpa.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPAMainService {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ProjectService projectService;

	//-------------------------------------- Department -----------------------------/

	public Department findDepartment(int departmentID) {
		return departmentService.find(departmentID);

	}

	public Department findDepartmentByName(String departmentName) {
		return departmentService.find(departmentName);

	}
	/**
	 *   Define a new department entity and insert it into the corresponding table
	 */
	 public void insertDepartment(String departmentName) {
         Department departmentToBeSaved = new Department();
         departmentToBeSaved.setName(departmentName);
         departmentService.save(departmentToBeSaved);
     }

	 /**
	 * Search for an existing department, update its name and save it using the new name
	 */
	public void updateDepartment(int departmentID, String newDepartmentName) {
        Department departmentToBeUpdated = findDepartment(departmentID);
        departmentToBeUpdated.setName(newDepartmentName);
        departmentService.update(departmentToBeUpdated);
    }

	/**
	 * Delete an existing department from the database
	 */
	public void deleteDepartment(int departmentID) {
        Department departmentToBeDeleted = findDepartment(departmentID);
        departmentService.remove(departmentToBeDeleted);
    }

	//-------------------------------------- Employee -----------------------------/
	/**
	 * Create a new employee entity and save it into the corresponding table
	 */
	public void insertEmployee() {}

	/**
	 * Print to stdout all the employees from 'Bucharest', which belong to the department with id = 1.
	 * Make sure that there are more than two employees in Bucharest which belong to the department with id=1 when populating the DB.
	 * ! Use a join query.
	 */
	public void getEmployeesFromBucharest(){}

	/**
	 * Give a salary raise(+10%) for all employees that work in the 'Endava' project (project name = 'Endava').
	 * ! Use a join query.
	 */
	public void giveSalaryRaise(){}


	//-------------------------------------- Project -----------------------------/

	/**
	 * Add a new employee to the 'Endava' project. (project name = 'Endava')
	 */
	public void addEmployee(){}

	/**
	 * Remove an employee from a project which has 'John Doe' as project manager.
	 */
	public void removeEmployee(){}

}
