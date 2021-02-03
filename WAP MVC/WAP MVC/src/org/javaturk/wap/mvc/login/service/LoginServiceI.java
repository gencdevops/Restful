package org.javaturk.wap.mvc.login.service;

import org.javaturk.wap.mvc.login.domain.User;


public interface LoginServiceI {

	public void populateUsers();

	public boolean authenticate(User loggingUser);

}