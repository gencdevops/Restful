package org.javaturk.rest.greet.client;

import java.text.MessageFormat;
import java.util.Map;
import java.util.logging.Logger;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Invocation.Builder;

public class GreetingResourceClient {
	private static WebTarget webTarget;
	private static Client client;

	private static final String BASE_URI = "http://localhost:7070/GreetingRest/resources";
	private static final Logger logger = Logger.getLogger(GreetingResourceClient.class.getName());

	static {
		client = ClientBuilder.newClient();
		webTarget = client.target(BASE_URI).path("greetings");
	}

	public static void main(String[] args) {
//		System.out.println("Count: " + getCount());
//		
//		System.out.println("\nAll greetings:");
//		Map<String, String> greetingMap = getAllGreetings();
//		greetingMap.forEach((l, g) -> System.out.println(l + " " + g));

		var greeting = getGreeting("turkish");
		System.out.println("\nTurkish greeting: " + greeting);
	}

	public static int getCount() throws ClientErrorException {
		WebTarget resource = webTarget.path("count");
		Builder builder = resource.request(MediaType.APPLICATION_JSON);
		Invocation invoation = builder.buildGet();
		return invoation.invoke(Integer.class);
	}

	public static Map<String, String> getAllGreetings() throws ClientErrorException {
		Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
		Invocation invoation = builder.buildGet();
		return invoation.invoke(Map.class);
	}

	public static String getGreeting(String language) throws ClientErrorException {
		WebTarget resource = webTarget.path(MessageFormat.format("{0}/2", new Object[] { language }));
		System.out.println(resource.getUri());
		Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
		Invocation invoation = builder.buildGet();
		var response = invoation.invoke(String.class);
		return response;
	}
}
