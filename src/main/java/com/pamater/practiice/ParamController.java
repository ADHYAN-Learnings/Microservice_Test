package com.pamater.practiice;

import org.springframework.beans.factory.annotation.Autowired;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;


@Path("/employee")
public class ParamController {
	
	@Autowired
	private ParamService paramService;
	
	@GET
	@Path("/{id}")
	public Employee getEmployeeById(@PathParam("id") Long id) {	
		return paramService.getDetailsById(id);
		
	}

	@GET
	@Path("name/{name}")
	public Employee getEmployeeByName(@PathParam("name") String name) {	
		return paramService.getDetailsByName(name);
		
	}
	
	@GET
	@Path("name/{name}/department/{department}")
	public Employee getEmployeeByNameAndDepartment(@PathParam("name") String name,@PathParam("department") String department) {	
		System.out.println("Name:"+name);
		System.out.println("Departement::"+department);
		return paramService.getDetailsByNameAndDepartment(name,department);
		
	}
	

}
