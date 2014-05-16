package com.endava.jpa.service.impl;

import com.endava.jpa.dao.DepartmentDao;
import com.endava.jpa.model.Department;
import com.endava.jpa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.*;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public Department find(int id) {
		return departmentDao.find(id);
	}

	@Override
	public Department find(String departmentName) {
		return departmentDao.find(departmentName);
	}

	@Override
	@Transactional
	public void save(Department toBeSaved) {
		departmentDao.save(toBeSaved);
	}

	@Override
	@Transactional
	public void update(Department toBeUpdated) {
		departmentDao.update(toBeUpdated);
	}

	@Override
	@Transactional
	public void remove(Department toBeRemoved) {
		// To be implemented
        departmentDao.remove(toBeRemoved);
	}
}
