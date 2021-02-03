package org.javaturk.rest.greet.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

//import io.swagger.config.Scanner;

import org.javaturk.rest.greet.domain.Greeting;
import org.javaturk.rest.greet.repo.GreetingRepository;


@Path("complexGreetings")
@Produces("application/json")
public class ComplexGreetingResource {

	private GreetingRepository repo = new GreetingRepository();
	private Jsonb jsonb;
	
	public ComplexGreetingResource() {
		jsonb = JsonbBuilder.create();
	}

	@POST
	public Response createGreeting1(Greeting greeting, @Context UriInfo uriInfo) {
		if (repo.addGreeting(greeting)) {
			String requestUriString = uriInfo.getAbsolutePath().getPath();
			int index = requestUriString.lastIndexOf('/');
			String newUriString = requestUriString.substring(0, index);
			URI uri = null;
			try {
				uri = new URI(newUriString);
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			return Response.created(uri).build();
		} else
			return Response.status(409).build();
	}
	
	@GET
	@Path("{language}")
	public String getGreeting1(@PathParam("language") String language) {
		String greeting = repo.getGreeting(language);
		if(greeting != null)
			return greeting;
		else
			return "No such language found: " + language;
	}
	
	@GET
	@Path("generic/{language}")
	public GenericEntity getGreeting2(@PathParam("language") String language) {
		String greeting = repo.getGreeting(language);
		if(greeting != null) {
			Greeting greetingObj = new Greeting(language, greeting);
			GenericEntity<Greeting> entity = new GenericEntity<>(greetingObj, Greeting.class);
			return entity;
		}
		else {
			GenericEntity<String> entity = new GenericEntity<>("No such language found: " + language, Greeting.class);
			return entity;
		}
	}
}
