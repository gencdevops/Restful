package org.javaturk.wap.mvc.login.allServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.javaturk.wap.mvc.login.controller.AbstractController;
import org.javaturk.wap.mvc.login.domain.User;
import org.javaturk.wap.mvc.login.service.LoginServiceFactory;
import org.javaturk.wap.mvc.login.service.LoginServiceI;

@WebServlet("/login.do")
public class LoginController extends AbstractController {

	private static String loginView = "loginForm1.view";
	private static String[] views = { "welcomeAdmin.view", "welcomePowerUser.view", "welcomeBranchUser.view", "welcomeDepartmentUser.view" };

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");

		User user = null;
		boolean outcome = false;

		List<String> errors = new ArrayList<String>();

		// Validate parameters
		validateParameters(username, password, role, errors);

		// If no validation errors exist
		if (errors.size() == 0) {
			user = new User(username, password, role);

			// Delegation to the business logic.
			outcome = callBusinessLogic(user);

			// Navigate one of the views
			navigate(request, response, outcome, user, views, loginView, errors);
		} else {
			request.setAttribute("errors", errors);
			sendError(request, response);
		}
	}
}