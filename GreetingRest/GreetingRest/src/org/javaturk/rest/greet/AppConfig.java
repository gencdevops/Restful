package org.javaturk.rest.greet;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.javaturk.rest.greet.resource.GreetingResource;

@ApplicationPath("resources")
public class AppConfig extends Application {

//
//	@Override
//	public Set<Class<?>> getClasses() {
//		Set<Class<?>> resources = new java.util.HashSet<>();
//		resources.add(GreetingResource.class);
//		return resources;
//	}

//	private Set<Object> singletons = new HashSet<>();
//	
//	/**
//	 * To make service object a singleton.
//	 */
//	public Set<Object> getSingletons(){
//		singletons.add(new GreetingResource());
//		return singletons;
//	}
}
