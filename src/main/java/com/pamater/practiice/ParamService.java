package com.pamater.practiice;

public interface ParamService {
	
	public Employee getDetailsById(Long id);
	
	public Employee getDetailsByName(String name);
	
	public Employee getDetailsByNameAndDepartment(String name,String department);


}
