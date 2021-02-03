package org.javaturk.rest.greet.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

//import io.swagger.config.Scanner;

import org.javaturk.rest.greet.domain.Greeting;
import org.javaturk.rest.greet.repo.GreetingRepository;


@Path("defaultGreetings")
public class DefaultGreetingResource {

	private GreetingRepository repo = new GreetingRepository();

	@GET
	public Map<String, String> getAllGreetings() {
		return repo.getAllGreetings();
	}
	
	@GET
	@Path("objects")
	public List<Greeting> getAllGreetingObjects() {
		return repo.getAllGreetingObjects();
	}
	
	@GET
	@Path("languages")
	public Set<String> getAllLanguages() {
		return repo.getAllLanguages();
	}

	@GET
	@Path("count")
	public int getGreetingCount() {
		return repo.getSize();
	}
	
	@GET
	@Path("containing/{language}")
	public boolean contains(@PathParam("language") String language) {
		return repo.contains(language);
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
	
	@POST
	@Path("{language}/{greeting}")
	public Response createGreetingByPathParam(@PathParam("language") String language, @PathParam("greeting") String greeting,
			@Context UriInfo uriInfo) {
		if (repo.addGreeting(language, greeting)) {
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
	
	@POST
	public Response createGreetingByQueryParam(@QueryParam("language") String language, @QueryParam("greeting") String greeting,
			@Context UriInfo uriInfo) {
		if (repo.addGreeting(language, greeting)) {
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
}
