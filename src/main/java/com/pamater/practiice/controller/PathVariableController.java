package com.pamater.practiice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pamater.practiice.Employee;
import com.pamater.practiice.service.ParamService;

@RestController
@RequestMapping("/employee/pathVariable")
public class PathVariableController {
	
	@Autowired
	private ParamService paramService;
	
	@GetMapping("/getAllDetails")
	public List<Employee> getEmployeeById() {
		return paramService.getAllDetails();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee  employee = paramService.getDetailsById(id);
		
		if(employee == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(employee);
	}
	
    @GetMapping("/name/{name}")
	public Employee getEmployeeByName(@PathVariable String name) {
	    return paramService.getDetailsByName(name);    	
	}
	
	@GetMapping("/nameAndDepartment/{name}/{department}")
	public Employee getEmployeeByDepartment(@PathVariable String name, @PathVariable String department) {
		return paramService.getDetailsByNameAndDepartment(name, department);
	}
	
	@PostMapping("/saveDetails")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
		boolean added = paramService.addDetailsById(employee);
		if(!added) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Employee already exists with ID"+employee.getId());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("Employee added successfully");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
		System.out.println("You are in delete service");
		 
		boolean deleted = paramService.deleteEmployeeById(id);
		if(!deleted) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found with Id: "+id);
		}
		
		return ResponseEntity.ok("Employee deleted successfully");
	}

}
