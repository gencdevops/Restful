package org.javaturk.wap.mvc.login.allServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.javaturk.wap.mvc.login.domain.User;

@WebServlet(name = "WelcomePowerUserServlet", urlPatterns="/welcomePowerUser.view")
public class WelcomePowerUserServlet extends AbstractWelcomeServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response, "Welcome Power User Page");
	}
}
