<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/WAPMVC/css/mystyles.css"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WAP MVC</title>
</head>
<body>
	<div align="center">
		<H2 ALIGN="CENTER">Login Page</H2>

		<form action="/WAPMVC/login2.do" method="post">
			<h3>
				<table width="500" border="1" cellpadding="0">
					<tr>
						<td><b>Username:</b></td>
						<td><input type=text name=username size=30 maxlength=20/></td>
					</tr>
					<tr>
						<td><b>Password:</b></td>
						<td><input type=password name=password size=30 maxlength=20/></td>
					</tr>
					<tr>
						<td rowspan="2"><b>Role:</b></td>
						<td align=left><input type=radio name=role value=branchuser
							checked/>Branch User <input type=radio name=role
							value=departmentuser>Department User</td>
					</tr>

					<tr>
						
						<td align=left><input type=radio name=role value=poweruser>Power
							User <input type=radio name=role value=admin>Admin</td>
					</tr>

					<tr>

						<td/>
						<td>
							<input type="submit" value="Login"
							style="font-family: sans-serif; font-size: 30px;" /> 
							
							<input type="reset" value="Clear"
							style="font-family: sans-serif; font-size: 30px;">
						</td>

					</tr>
				</table>
			</h3>
		</form>
	</div>
	
<%= "<p><h4><a href=\"SourceCodeServlet?dir=&name=login\">For Source Code</h4></a>" %>
</body>
</html>