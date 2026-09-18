package com.pamater.practiice;

public class Employee {
	
	private Long id;
	private String name;
	private String department;
	private String designation;
	private double Salary;
	
	public Employee() {
		super();
	}
	
	public Employee(Long id, String name, String department, String designation, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.designation = designation;
		Salary = salary;
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDepartment() {
		return department;
	}
	public String getDesignation() {
		return designation;
	}
	public double getSalary() {
		return Salary;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", designation=" + designation
				+ ", Salary=" + Salary + "]";
	}

}
