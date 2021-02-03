package org.javaturk.rest.ch06.resource;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.javaturk.rest.ch06.domain.*;
import org.javaturk.rest.ch06.repo.EmployeeRepository;

@Path("employees")
@Produces("application/json")
public class EmployeeResource {
	
	private EmployeeRepository repo = new EmployeeRepository();

	@GET
	public List<Employee> getAllEmployees() {
		return repo.getAllEmployees();
	}
	
	@GET
	@Path("count")
	public int getEmployeeCount() {
		return repo.getEmployeeCount();
	}
	
	@GET
	@Path("{id}")
	public Employee getEmployee(@PathParam ("id") long id) {
		return repo.getEmployee(id);
	}
	
	@GET
	@Path("name/{id}")
	public String getEmployeeName(@PathParam ("id") long id) {
		return repo.getEmployee(id).getName();
	}
	
	@GET
	@Path("salary/{id}")
	public double getEmployeeSalary(@PathParam ("id") long id) {
		return repo.getEmployee(id).getSalary();
	}
	
	@GET
	@Path("sex/{id}")
	public char getEmployeeSex(@PathParam ("id") long id) {
		return repo.getEmployee(id).getSex();
	}
	
	@GET
	@Path("date/{id}")
	public ZonedDateTime getEmployeeStartingDate(@PathParam ("id") long id) {
		return repo.getEmployee(id).getStartingDate();
	}
	
	@GET
	@Path("dob/{id}")
	public LocalDateTime getEmployeeDob(@PathParam ("id") long id) {
		return repo.getEmployee(id).getDob();
	}
	
	@GET
	@Path("work-mode/{id}")
	public boolean getEmployeeMode(@PathParam ("id") long id) {
		return repo.getEmployee(id).isFullTime();
	}
	
	@GET
	@Path("rank/{id}")
	public EmployeeRank getEmployeeRank(@PathParam ("id") long id) {
		return repo.getEmployee(id).getRank();
	}
	@GET
	@Path("department/{id}")
	public Department getEmployeeDepartment(@PathParam ("id") long id) {
		return repo.getEmployee(id).getDepartment();
	}
}
