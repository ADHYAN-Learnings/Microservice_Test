package com.pamater.practiice.service;

import java.util.List;

import com.pamater.practiice.Employee;

public interface ParamService {
	
	public Employee getDetailsById(Long id);
	
	public Employee getDetailsByName(String name);
	
	public Employee getDetailsByNameAndDepartment(String name,String department);
	
	public boolean addDetailsById(Employee employee);
	
	public boolean deleteEmployeeById(Long id);
	
	public List<Employee> getAllDetails();


}
