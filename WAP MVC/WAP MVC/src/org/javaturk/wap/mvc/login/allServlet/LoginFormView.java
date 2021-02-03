package org.javaturk.wap.mvc.login.allServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginForm1.view")
public class LoginFormView extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML><HEAD>");
		out.println("<link rel='stylesheet' type='text/css' href='css/mystyles.css'>");
		out.println("<TITLE>Login</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<h3>");

		printForm(out);
		printErrors(out, request);

		out.println("<P><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.mvc.login.allServlet.LoginFormView\">For Source Code</h4></a>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void printForm(PrintWriter out) {
		out.println("<div align='center'> <H2 ALIGN='CENTER'>Login Page</H2>");
		out.println("<form action='login.do' method='post'>");
		out.println("<h3>");
		out.println("<table width='500' border='1' cellpadding='0'>");
		out.println("<tr>");
		out.println("<td><b>Username:</b></td>");
		out.println("<td><input type=text name=username size=30 maxlength=20/></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><b>Password:</b></td>");
		out.println("<td><input type=password name=password size=30 maxlength=20/></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td rowspan='2'><b>Role:</b></td>");
		out.println(
				"<td align=left><input type=radio name=role value=branchuser />Branch User <input type=radio name=role value=departmentuser>Department User</td>");
		out.println("</tr>");

		out.println("<tr>");

		out.println("<td align=left><input type=radio name=role value=poweruser>Power User <input type=radio name=role value=admin>Admin</td>");
		out.println("</tr>");

		out.println("<tr>");

		out.println("<td/>");
		out.println("<td>");
		out.println("<input type='submit' value='Login'/>");

		out.println("<input type='reset' value='Clear'>");
		out.println("</td>");

		out.println("</tr>");
		out.println("</table>");
		out.println("</h3>");
		out.println("</form>");
	}

	public void printErrors(PrintWriter out, HttpServletRequest request) {
		List<String> errors = (List<String>) request.getAttribute("errors");
		if (errors != null) {
			out.println("<Center>");
			out.println("<p>");
			out.println("<h3>");
			out.println("Following errors happen:");
			out.println("</h3>");
			out.println("</p>");
			out.println("<p>");
			out.println("<h2>");
			for (String error : errors)
				out.println(error + "<br/>");
			out.println("</h2>");
			out.println("</p>");
			out.println("</p>");
			out.println("</Center>");
		}
	}
}
