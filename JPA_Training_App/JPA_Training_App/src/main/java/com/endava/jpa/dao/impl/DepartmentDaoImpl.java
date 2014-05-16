package com.endava.jpa.dao.impl;

import com.endava.jpa.dao.DepartmentDao;
import com.endava.jpa.model.Department;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

	@PersistenceContext
	private EntityManager entityManager;

	private String QUERY_FIND_DEPARTMENT_BY_NAME = "Select d from Department d where d.name = :dep_name";

	@Override
	public Department find(int id) {
		return entityManager.find(Department.class, id);
	}

	public Department find(String departmentName) {

        Department department = null;
		List<Department> departmentList = entityManager.createQuery(QUERY_FIND_DEPARTMENT_BY_NAME)
				.setParameter("dep_name", departmentName)
				.getResultList();
        if(departmentList.size() > 0){
            department = departmentList.get(0);
        }

        return  department;

	}

	@Override
	public void save(Department toBeSaved) {
		// To be implemented
        entityManager.persist(toBeSaved);
        entityManager.flush();
	}

	@Override
	public void update(Department toBeUpdated) {
		// To be implemented
        entityManager.merge(toBeUpdated);
        entityManager.flush();

	}

    /**
     * We need to firstly merge the object because the parameter is given as a detached entity. Since the find operation for the given parameter is in another transaction,
     * it means that it is part of a different persistence context from the remove operation.
     * @param toBeRemoved
     */
	@Override
	public void remove(Department toBeRemoved) {
		// To be implemented
        entityManager.remove(entityManager.merge(toBeRemoved));
        entityManager.flush();
	}
}
