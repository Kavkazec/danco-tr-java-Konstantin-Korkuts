package com.danco.point.api;

import java.util.List;

import com.danco.point.entity.Employee;

public interface IEmployeeService {
	public List<Employee> getEmployees();
	
	public void exportGuests(List<Employee> list);
	
	public void importGuests();
	
}
