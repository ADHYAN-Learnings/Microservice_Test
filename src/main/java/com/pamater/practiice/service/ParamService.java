package com.pamater.practiice.service;

import com.pamater.practiice.Employee;

public interface ParamService {
	
	public Employee getDetailsById(Long id);
	
	public Employee getDetailsByName(String name);
	
	public Employee getDetailsByNameAndDepartment(String name,String department);


}
