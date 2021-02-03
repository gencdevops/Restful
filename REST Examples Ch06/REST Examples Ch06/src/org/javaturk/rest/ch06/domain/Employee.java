package org.javaturk.rest.ch06.domain;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Employee {
	private long id;
	private String name;
	private char sex;
	private LocalDateTime dob;
	private boolean fullTime;
	private ZonedDateTime startingDate;
	private EmployeeRank rank;
	private double salary;
	private Department department;
	
	public Employee() {
		dob = LocalDateTime.now().withYear(1982);
		startingDate = ZonedDateTime.now();
	}
	
	public Employee(long id, String name, char sex, boolean fullTime, EmployeeRank rank, double salary, Department department) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.fullTime = fullTime;
		this.rank = rank;
		this.salary = salary;
		this.department = department;
		dob = LocalDateTime.now().withYear(1982);
		startingDate = ZonedDateTime.now();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}
	
	public LocalDateTime getDob() {
		return dob;
	}

	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}

	public boolean isFullTime() {
		return fullTime;
	}

	public void setFullTime(boolean fullTime) {
		this.fullTime = fullTime;
	}

	public ZonedDateTime getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(ZonedDateTime startingDate) {
		this.startingDate = startingDate;
	}

	public EmployeeRank getRank() {
		return rank;
	}

	public void setRank(EmployeeRank rank) {
		this.rank = rank;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sex=" + sex + ", dob=" + dob + ", fullTime=" + fullTime
				+ ", startingDate=" + startingDate + ", rank=" + rank + ", salary=" + salary + ", department="
				+ department + "]";
	}
}
