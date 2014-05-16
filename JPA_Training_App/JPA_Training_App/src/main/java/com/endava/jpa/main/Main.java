package com.endava.jpa.main;

import com.endava.jpa.model.Department;
import com.endava.jpa.service.impl.JPAMainService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		JPAMainService jpaMainService = (JPAMainService)context.getBean("JPAMainService");

		/**
		 * Comment unneeded method invocations.
		 */



           Department departmentITS = jpaMainService.findDepartmentByName("IT Services");
//        jpaMainService.updateDepartment(departmentITS.getId(), "IT Services");
//        jpaMainService.deleteDepartment(departmentITS.getId());




		/*
		jpaMainService.insertDepartment();
		jpaMainService.updateDepartment();
		jpaMainService.deleteDepartment();
		jpaMainService.insertEmployee();
		jpaMainService.getEmployeesFromBucharest();
		jpaMainService.giveSalaryRaise();
		jpaMainService.removeEmployee();
		*/

	}
}
