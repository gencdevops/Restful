<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false"%>
<html xmlns:c="http://java.sun.com/jsp/jstl/core">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Admin JSP Page</title>
</head>
<body>
	<p>
	<h1 align="center">Welcome Admin User JSP Page</h1>
	
	<p>
	<jsp:include page="/jsp/userInfo.jsp" />
	
	<p>
	<%= "<p><h4><a href=\"/WAPMVC/SourceCodeServlet?dir=&name=welcomeAdmin\">For Source Code</h4></a>" %>
</body>
</html>