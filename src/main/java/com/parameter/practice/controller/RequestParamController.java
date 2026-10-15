package com.parameter.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.parameter.practice.Employee;
import com.parameter.practice.service.ParamService;


@RestController
@RequestMapping("/employee/requestParam")
public class RequestParamController {

	@Autowired
	private ParamService paramService;
	
	@GetMapping("/id")
	public Employee getEmployeeById(@RequestParam Long id) {
		return paramService.getDetailsById(id);
	}
	
    @GetMapping("/name")
	public Employee getEmployeeByName(@RequestParam String name) {
	    return paramService.getDetailsByName(name);    	
	}
	
	@GetMapping("/name/department")
	public Employee getEmployeeByDepartment(@RequestParam String name,@RequestParam String department) {
		return paramService.getDetailsByNameAndDepartment(name, department);
	}

}
