package org.javaturk.rest.ch06.resource;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

//@Path("x")
@Produces("application/json")
public class WeirdResource {
	
	@GET
	@Path("weirdos")
	public String getAllWeirds() {
		return "I am a weirdo!";
	}
}
