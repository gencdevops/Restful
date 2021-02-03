package org.javaturk.rest.greet.client;

import java.text.MessageFormat;
import java.util.Map;
import java.util.logging.Logger;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.javaturk.rest.greet.domain.Greeting;

public class ComplexGreetingResourceClient {

	private static WebTarget webTarget;
	private static Client client;

	private static final String BASE_URI = "http://localhost:7070/GreetingRest/resources";
	private static final Logger logger = Logger.getLogger(GreetingResourceClient.class.getName());

	static {
		client = ClientBuilder.newClient();
		webTarget = client.target(BASE_URI).path("complexGreetings");
	}

	public static void main(String[] args) {
		createGreeting();
//		getGreeting("turkish");
	}

	public static int getCount() throws ClientErrorException {
		WebTarget resource = webTarget.path("count");
		Builder builder = resource.request(MediaType.APPLICATION_JSON);
		Invocation invoation = builder.buildGet();
		return invoation.invoke(Integer.class);
	}

	public static void getGreeting(String language) throws ClientErrorException {
		WebTarget resource = webTarget.path(MessageFormat.format("generic/{0}", new Object[] {language}));
		Builder builder = resource.request(MediaType.APPLICATION_JSON);
		Invocation invoation = builder.buildGet();
		GenericEntity genericEntity = invoation.invoke(GenericEntity.class);
		Object entity = genericEntity.getEntity();
		if (entity instanceof Greeting) {
			Greeting g = (Greeting) entity;
			System.out.println(g);
		}
		else
			System.out.println(entity);
	}

	public static void createGreeting() throws ClientErrorException {
		Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
		Entity<Greeting> greeting = Entity.entity(new Greeting("greek", "Χαίρετε"), "application/json");
		Invocation invoation = builder.buildPost(greeting);
		Response respons = invoation.invoke(Response.class);
	}
}
