<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<% 
String login = request.getParameter("login");
String password = request.getParameter("pwd");
%>
<html>
	<body>
		<% out.print(login); %>
		<br>
		<%=password %>
	</body>
</html>