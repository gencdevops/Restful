<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="org.javaturk.wap.mvc.login.domain.User"%>
<%@ page import="java.util.Date"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LoginControllerJSP</title>
</head>
<body>

	<jsp:useBean id="loginBean"
		class="org.javaturk.wap.mvc.login.model1.LoginBean" />

	<jsp:setProperty name="loginBean" property="*" />

	<%
		request.setAttribute("date", new Date());
	
		boolean outcome = loginBean.authenticateUser();
	
		if (outcome) {
			User user = loginBean.getUser();
			session.setAttribute("user", user);
			String role = request.getParameter("role");

			if (role.equals("admin")){  %>
			
				<jsp:forward page="/jsp/welcomeAdmin.jsp"/>;
				
	<%	}
			else if (role.equals("poweruser")) {
	 %>
				<jsp:forward page="/jsp/welcomePowerUser.jsp"/>
	<%		}
			else if (role.equals("branchuser")) {
	%>
				<jsp:forward page="/jsp/welcomeBranchUser.jsp"/>
	<% 		}
			else if (role.equals("departmentuser")){
	%>
				<jsp:forward page="/jsp/welcomeDepartmentUser.jsp"/>
	<% 		}
		}
		else
	%>
			<jsp:forward page="/jsp/model1/login.jsp"/>

</body>
</html>