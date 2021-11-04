package com.multitenancy.app.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.multitenancy.app.data.Employee;

@Repository
@Transactional
public interface EmployeeDAO extends CrudRepository<Employee,Integer> {
	    List<Employee> findAll();                           // pega todos os empregados
	}

