package com.pamater.practiice.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.pamater.practiice.Employee;
import com.pamater.practiice.service.ParamService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/query")
public class QueryParamController {
	
	@Autowired
	private ParamService paramService;
	
	@GET
	@Path("/employee")
	public Employee getEmployeeById(@QueryParam("id") Long id) {
		return paramService.getDetailsById(id);
	}
	
	@GET
	@Path("/employee/name")
	public Employee getEmployeeByName(@QueryParam("name") String name) {
		System.out.println("Name = "+name);
	    return paramService.getDetailsByName(name);    	
	}
	
	@GET
	@Path("/employee/nameAndDepartment")
	public Employee getEmployeeByDepartment(@QueryParam("name") String name,@QueryParam("department") String department) {
		return paramService.getDetailsByNameAndDepartment(name, department);
	}

}
 
  