<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Enumeration"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="org.javaturk.wap.mvc.login.domain.User"%>

<!-- This file imported into other view files. -->

<h3 align="center">
	<p>
		<c:if test="${spring}">
			<font size="4" color="red">Coming from Spring controller.</font>
		</c:if>
	</p>

	<p>${date}</p>

	<!-- 	<p> -->

	<%-- 		<% --%>
	<!-- // 			Enumeration<String> reqEnum = request.getAttributeNames(); -->
	<!-- // 			while (reqEnum.hasMoreElements()) { -->
	<!-- // 				String s = reqEnum.nextElement(); -->
	<!-- // 				out.print(s); -->
	<!-- // 				out.println("==" + request.getAttribute(s)); -->
	<%-- 		%><br /> --%>
	<%-- 		<% --%>
	<!-- // 			} -->
	<%-- 		%> --%>

	<!-- 	</p> -->

	<p>

		<%
			User user = (User) session.getAttribute("user");
			out.println("Username: " + user.getUsername());
		%>

	</p>

	<p>\${user.username}: ${user.username}</p>
	<p>\${sessionScope.user.username}: ${sessionScope.user.username}</p>
	<p>\${param.username} : ${param.username}</p>
	<p>\${param.password} : ${param.password}</p>
	<p>\${param.role} : ${param.role}</p>
</h3>
