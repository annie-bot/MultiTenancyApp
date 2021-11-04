package com.multitenancy.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multitenancy.app.DAO.EmployeeDAO;
import com.multitenancy.app.data.Employee;

public class EmployeeController {
	
	 @Autowired
	    private EmployeeDAO employeeDAO;
	    @RequestMapping(value = "employeeList")
	    public java.util.List<Employee> employeeList() {
	        return employeeDAO.findAll();
	    }

}
