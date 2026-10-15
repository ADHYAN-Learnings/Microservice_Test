package com.parameter.practice.service;

import java.util.List;

import com.parameter.practice.Employee;

public interface ParamService {
	
	public Employee getDetailsById(Long id);
	
	public Employee getDetailsByName(String name);
	
	public Employee getDetailsByNameAndDepartment(String name,String department);
	
	public boolean addDetailsById(Employee employee);
	
	public boolean deleteEmployeeById(Long id);
	
	public List<Employee> getAllDetails();


}
