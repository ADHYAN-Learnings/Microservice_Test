package com.pamater.practiice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ParmaServiceImpl implements ParamService {
	
	@Override
	public Employee getDetailsById(Long id) {
		
		List<Employee> employeeData = getData();
		
		return employeeData.stream().filter(employee->employee.getId().equals(id)).findAny().get();
	}
	
	
	private List<Employee> getData(){
    
		 List<Employee> employeeList = new ArrayList<Employee>();
		
		employeeList.add(new Employee(1001l,"John","Mechanical","Assistant",15000.00));
		employeeList.add(new Employee(1002l,"Steward","Biology","Assocate",25000.00));
		employeeList.add(new Employee(1003l,"Matthews","Mechanical","Assistant",15000.00));
		employeeList.add(new Employee(1004l,"Barry","Computer","Associate",25000.00));
		employeeList.add(new Employee(1005l,"Wade","Computer","Lead",450000.00));
		employeeList.add(new Employee(1006l,"ChintaMani","Botany","Manager",100000.00));
		employeeList.add(new Employee(1007l,"Suresh","Civil","Manager",100000.00));
		employeeList.add(new Employee(1008l,"Clark","Botany","Director",1500000.00));
		employeeList.add(new Employee(1009l,"Majeesh","Civil","Delivery",90000.00));
		employeeList.add(new Employee(2001l,"Priyanka","Mechanical","Sales",55000.00));
		employeeList.add(new Employee(2002l,"Needhi","Mechanical","Sales",25000.00));
		employeeList.add(new Employee(2003l,"Peter","Botany","Director",1500000.00));
		employeeList.add(new Employee(2004l,"Narendra","Astronomy","Delivery",75000.00));
		employeeList.add(new Employee(2005l,"Kanchan","Astronomy","Delivery",75000.00));
		
		return employeeList;
	}


	@Override
	public Employee getDetailsByName(String name) {
		List<Employee> employeeData = getData();
		return employeeData.stream().filter(employee->employee.getName().equalsIgnoreCase(name)).findAny().get();
	}


	@Override
	public Employee getDetailsByNameAndDepartment(String name, String department) {
		
		List<Employee> employeeData = getData();
		System.out.println("Name:"+name);
		System.out.println("Departement::"+department);
		return employeeData.stream()
				           .filter(employee->employee.getName().equalsIgnoreCase(name) && 
				        		   employee.getDepartment().equalsIgnoreCase(department))
				           .findAny().get();
	}

}
