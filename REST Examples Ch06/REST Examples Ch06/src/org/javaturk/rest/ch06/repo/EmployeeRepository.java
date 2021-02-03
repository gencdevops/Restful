package org.javaturk.rest.ch06.repo;

import java.util.ArrayList;
import java.util.List;

import org.javaturk.rest.ch06.domain.Employee;
import org.javaturk.rest.ch06.domain.EmployeeFactory;

public class EmployeeRepository {

	private static List<Employee> employees = new ArrayList<>();

	static {
		EmployeeFactory factory = new EmployeeFactory();
		for (int i = 0; i < 10; i++)
			employees.add(factory.createEmployee());
	}

	public List<Employee> getAllEmployees() {
		return employees;
	}

	public Employee getEmployee(long id) {
		Employee employee = null;
		for (Employee e : employees)
			if (e.getId() == id) {
				employee = e;
				break;
			}
		return employee;
	}

	public int getEmployeeCount() {
		return employees.size();
	}

}
