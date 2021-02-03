package org.javaturk.rest.ch06.domain;

public class EmployeeFactory {
	
	public Employee createEmployee() {
		Employee employee = null;
		long id = EmployeeRandomizer.createId();
		String name = EmployeeRandomizer.createName();
		char sex = EmployeeRandomizer.createSex();
		Department department = EmployeeRandomizer.createDepartment();
		EmployeeRank rank = EmployeeRandomizer.createRank();
		employee = new Employee(id, name, sex, true, rank, 12529.77, department);
		return employee;
	}

}
