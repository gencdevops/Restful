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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

//import io.swagger.config.Scanner;

import org.javaturk.rest.greet.domain.Greeting;
import org.javaturk.rest.greet.repo.GreetingRepository;


@Path("greetings")
@Produces("application/json")
public class GreetingResource {

	private GreetingRepository repo = new GreetingRepository();
	private Jsonb jsonb;
	
	public GreetingResource() {
		jsonb = JsonbBuilder.create();
	}

	@GET
	public Map<String, String> getAllGreetings() {
		return repo.getAllGreetings();
	}
	
	@GET
	@Path("objects")
	@Produces("application/json")
	public List<Greeting> getAllGreetingObjectsAsJSON() {
		System.out.println("in getAllGreetingObjectsAsJSON()");
		return repo.getAllGreetingObjects();
	}

	@GET
	@Path("objects")
	@Produces("application/xml")
	public List<Greeting> getAllGreetingObjectsAsXML() {
		System.out.println("in getAllGreetingObjectsAsXML()");
		return repo.getAllGreetingObjects();
	}
	
	@GET
	@Path("objectsJSONorXML")
	@Produces({"application/json", "application/xml"})
	public List<Greeting> getAllGreetingObjectsAsXMLorJSON() {
		System.out.println("in getAllGreetingObjectsAsXMLorJSON()");
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
	@Path("{language}/1")
	public String getGreeting1(@PathParam("language") String language) {
		String greeting = repo.getGreeting(language);
		if(greeting != null)
			return greeting;
		else
			return "No such language found: " + language;
	}
	
	@GET
	@Path("{language}/2")
	public Response getGreeting2(@PathParam("language") String language) {
		String greeting = repo.getGreeting(language);
		if(greeting != null)
			return Response.status(200).entity(jsonb.toJson(greeting)).build();
		else
			return Response.status(404).entity(jsonb.toJson("No such language found: " + language)).build();
	}
	
	@GET
	@Path("{language}/3")
	public String getGreeting3(@PathParam("language") String language) {
		String greeting = repo.getGreeting(language);
		if(greeting != null)
			return jsonb.toJson(greeting);
		else
			return jsonb.toJson("No such language found: " + language);
	}
	
	@GET
	@Path("query")
	public Response getGreeting4(@QueryParam("language") String language) {
		String greeting = repo.getGreeting(language);
		if(greeting != null)
			return Response.status(200).entity(jsonb.toJson(greeting)).build();
		else
			return Response.status(404).entity(jsonb.toJson("No such language found: " + language)).build();
	}
	
	@GET
	@Path("containing/{language}")
	public boolean contains(@PathParam("language") String language) {
		return repo.contains(language);
	}

	@POST
	@Path("{language}/{greeting}")
	public Response createGreeting(@PathParam("language") String language, @PathParam("greeting") String greeting,
			@Context UriInfo uriInfo) {
		if (repo.addGreeting(language, greeting)) {
			String requestUriString = uriInfo.getAbsolutePath().getPath();
			int index = requestUriString.lastIndexOf('/');
			String newUriString = requestUriString.substring(0, index) + "/1";
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

	@PUT
	@Path("{language}/{greeting}")
	public Response updateGreeting(@PathParam("language") String language, @PathParam("greeting") String greeting,
			@Context UriInfo uriInfo) {
		if (repo.updateGreeting(language, greeting)) {
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

	@DELETE
	@Path("{language}")
	public Response deleteGreeting(@PathParam("language") String language, @Context UriInfo uriInfo) {
		if (repo.deleteGreeting(language))
			return Response.status(200).build();
		else
			return Response.status(204).entity("No such language found: " + language).build();
	}
}
