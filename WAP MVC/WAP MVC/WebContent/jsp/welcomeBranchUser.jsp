<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Branch User JSP Page</title>
</head>
<body>
	<p>
	<h1 align="center">Welcome Branch User JSP Page</h1>
	</p>
	<jsp:include page="/jsp/userInfo.jsp" />
	
	<p>
	<%= "<p><h4><a href=\"/WAPMVC/SourceCodeServlet?dir=&name=welcomeBranchUser\">For Source Code</h4></a>" %>
</body>
</html>