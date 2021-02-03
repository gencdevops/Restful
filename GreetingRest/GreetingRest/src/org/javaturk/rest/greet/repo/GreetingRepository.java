package org.javaturk.rest.greet.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.javaturk.rest.greet.domain.Greeting;

public class GreetingRepository {

	private static Map<String, String> greetingMap = new ConcurrentHashMap<>();
	private static List<Greeting> greetingList = new ArrayList<>();

	static {
		Greeting greeting = new Greeting("turkish", "selam");
		greetingList.add(greeting);
		greetingMap.put(greeting.getLanguage(), greeting.getGreeting());

		greeting = new Greeting("english", "hello");
		greetingList.add(greeting);
		greetingMap.put(greeting.getLanguage(), greeting.getGreeting());

		greeting = new Greeting("french", "bonjour");
		greetingList.add(greeting);
		greetingMap.put(greeting.getLanguage(), greeting.getGreeting());

		greeting = new Greeting("spanish", "hola");
		greetingMap.put(greeting.getLanguage(), greeting.getGreeting());
		greetingList.add(greeting);
	}

	public GreetingRepository() {
	}

	public int getSize() {
		return greetingMap.size();
	}

	public String getGreeting(String language) {
		if (greetingMap.containsKey(language))
			return greetingMap.get(language);
		else
			return null;
	}

	public Map<String, String> getAllGreetings() {
		return greetingMap;
	}

	public List<Greeting> getAllGreetingObjects() {
		return greetingList;
	}

	public Set<String> getAllLanguages() {
		return greetingMap.keySet();
	}

	public boolean addGreeting(String language, String greeting) {
		if (!greetingMap.containsKey(language)) {
			greetingMap.put(language, greeting);
			return true;
		} else
			return false;
	}
	
	public boolean addGreeting(Greeting greeting) {
		return addGreeting(greeting.getLanguage(), greeting.getGreeting());
	}

	public boolean deleteGreeting(String language) {
		if (greetingMap.containsKey(language)) {
			greetingMap.remove(language);
			return true;
		} else
			return false;
	}

	public boolean updateGreeting(String language, String greeting) {
		if (greetingMap.containsKey(language)) {
			greetingMap.replace(language, greeting);
			return true;
		} else
			return false;
	}

	public boolean contains(String language) {
		if (greetingMap.containsKey(language))
			return true;
		else
			return false;
	}
}
