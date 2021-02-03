package org.javaturk.wap.mvc.login.allServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.javaturk.wap.mvc.login.domain.User;

public abstract class AbstractWelcomeServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response, String title) throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Date date = (Date) request.getAttribute("date");
		
		String name = getServletName();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML><HEAD>");
		out.println("<TITLE>Welcome Admin Page</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<h1 align=\"center\">" + title + "</h1>");
		out.println("<h2 align=\"center\">" + name + "</h2>");
		out.println("<h3 align=\"center\">" + date + "</h3>");
		out.println("<h3 align=\"center\">");
		out.println("Username: " + user.getUsername() + "<br/>");
		out.println("Password: " + user.getPassword() + "<br/>");
		out.println("Role: " + user.getRole() + "<br/>");
		out.println("</h3>");

		printFooter(out);
	}
	
	protected void printFooter(PrintWriter out) {
		StringBuffer sb = new StringBuffer();
		sb.append("<br/>");
		sb.append("<p><h4><a href='SourceCodeServlet?name=" + getClass().getName() + "'>For Source Code</h4></a></p>");
		sb.append("<p><h4><a href='SourceCodeServlet?name=org.javaturk.wap.mvc.login.allServlet.AbstractWelcomeServlet'>For Source Code of AbstractWelcomeServlet</h4></a></p>");
		sb.append("</body></html>");
		out.println(sb.toString());
		out.close();
	}
}
