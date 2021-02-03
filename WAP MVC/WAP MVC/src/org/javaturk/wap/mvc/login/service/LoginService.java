package org.javaturk.wap.mvc.login.service;

import java.util.HashMap;
import java.util.Map;

import org.javaturk.wap.mvc.login.domain.User;

public class LoginService implements LoginServiceI {
	private Map<String, User> users;
	
	public LoginService(){
		users = new HashMap<String, User>();
		populateUsers();
	}
	
	@Override
	public void populateUsers(){
		User user = new User("akin", "pa", "admin");
		users.put(user.getUsername(), user);
		
		user = new User("a", "b", "branchuser");
		users.put(user.getUsername(), user);
		
		user = new User("selim", "selim", "poweruser");
		users.put(user.getUsername(), user);
		
		user = new User("dilek", "dilek", "departmentuser");
		users.put(user.getUsername(), user);
		
		user = new User("a", "a", "admin");
		users.put(user.getUsername(), user);
		
		user = new User("b", "b", "branchuser");
		users.put(user.getUsername(), user);
		
		user = new User("p", "p", "poweruser");
		users.put(user.getUsername(), user);
		
		user = new User("d", "d", "departmentuser");
		users.put(user.getUsername(), user);
		
		user = new User("x", "y", "departmentuser");
		users.put(user.getUsername(), user);
		
		user = new User("fatih", "fatih", "branchuser");
		users.put(user.getUsername(), user);
	}
	
	@Override
	public boolean authenticate(User loggingUser){
		boolean isUser = false;
		String username = loggingUser.getUsername();
		if(users.containsKey(username)){
			User user = users.get(username);
			if(user.getPassword().equals(loggingUser.getPassword()) && 
			   user.getRole().equals(loggingUser.getRole()))
				isUser = true;
		}
		return isUser;
	}
}
