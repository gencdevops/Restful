package org.javaturk.wap.mvc.login.model1;

import org.javaturk.wap.mvc.login.domain.User;
import org.javaturk.wap.mvc.login.service.LoginServiceFactory;
import org.javaturk.wap.mvc.login.service.LoginServiceI;

public class LoginBean {
	private String username;
	private String password;
	private String role;
	
	private User user;

	private LoginServiceI loginService;

	public LoginBean() {
		LoginServiceFactory loginServiceFactory = LoginServiceFactory.getInstance();
		loginService = loginServiceFactory.getLoginService();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public boolean authenticateUser() {
		user = new User(username, password, role);
//		System.out.println(user);
		boolean outcome = loginService.authenticate(user);
		return outcome;
	}
}
