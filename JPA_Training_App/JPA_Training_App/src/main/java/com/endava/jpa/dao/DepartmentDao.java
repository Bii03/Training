package com.endava.jpa.dao;

import com.endava.jpa.model.Department;

import java.util.List;

public interface DepartmentDao {

	public Department find(int id);

	public Department find(String departmentName);

	public void save(Department toBeSaved);

	public void update(Department toBeUpdated);

	public void remove(Department toBeRemoved);
}
