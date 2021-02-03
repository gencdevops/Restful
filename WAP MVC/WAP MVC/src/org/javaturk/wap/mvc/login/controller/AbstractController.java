package org.javaturk.wap.mvc.login.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.javaturk.wap.mvc.login.domain.User;
import org.javaturk.wap.mvc.login.service.LoginServiceFactory;
import org.javaturk.wap.mvc.login.service.LoginServiceI;

public abstract class AbstractController extends HttpServlet {

	/**
	 * Validates reuqets parameters.
	 * 
	 * @param username
	 *            Username submitted
	 * @param password
	 *            Password submitted
	 * @param role
	 *            Role submitted
	 * @param errors
	 *            List for rrrors
	 */
	public void validateParameters(String username, String password, String role, List<String> errors) {

		if (!validate(username))
			errors.add("Username must be provided!");

		if (!validate(password))
			errors.add("Pasword must be provided!");

		if (!validate(role))
			errors.add("Role must be chosen!");
	}

	/**
	 * Calls business logic behind the controller.
	 * 
	 * @param user
	 *            User to be authenticated.
	 * @return true if authenticated.
	 */
	protected boolean callBusinessLogic(User user) {
		LoginServiceFactory loginServiceFactory = LoginServiceFactory.getInstance();
		LoginServiceI loginService = loginServiceFactory.getLoginService();
		boolean outcome = loginService.authenticate(user);
		return outcome;
	}

	/**
	 * Navigates to chosen view depending on the inputs.
	 * @param request HttpServletRequest object
	 * @param response HttpServletResponse object
	 * @param outcome Outcome of the business logic
	 * @param user User authenticated
	 * @param views Array that holds the views.
	 * @param loginView Login view
	 * @param errors List that holds the errors
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void navigate(HttpServletRequest request, HttpServletResponse response, boolean outcome, User user, String[] views, String loginView,
			List<String> errors) throws ServletException, IOException {
		request.setAttribute("date", new Date());

		RequestDispatcher dispatcher = null;

		if (outcome) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);

			String role = user.getRole();
			
			if (role.equals("admin")) {
				dispatcher = request.getRequestDispatcher(views[0]);
				dispatcher.forward(request, response);
			} else if (role.equals("poweruser")) {
				dispatcher = request.getRequestDispatcher(views[1]);
				dispatcher.forward(request, response);
			} else if (role.equals("branchuser")) {
				dispatcher = request.getRequestDispatcher(views[2]);
				dispatcher.forward(request, response);
			} else if (role.equals("departmentuser")) {
				dispatcher = request.getRequestDispatcher(views[3]);
				dispatcher.forward(request, response);
			}
		} else {
			request.setAttribute("error", "Wrong username, password and/or role information provided.");
			dispatcher = request.getRequestDispatcher(loginView);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * Sends an error to the client.
	 * 
	 * @param request
	 *            HttpServletRequest object
	 * @param response
	 *            HttpServletResponse object
	 */
	protected void sendError(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("loginForm1.view");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			System.err.println("Problem wşth dispatching: " + e.getMessage());
		}
	}

	/**
	 * Valdiates the parameter submitted from the browser.
	 * 
	 * @author akin
	 * 
	 * @param arg
	 *            Parameter to be validated
	 * @return true if validated false otherwise.
	 */
	protected boolean validate(String arg) {
		boolean b = true;
		if (arg == null)
			b = false;
		else {
			if (arg.isEmpty())
				b = false;
		}
		return b;
	}
}
