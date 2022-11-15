<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");

String email = request.getParameter("email");
String name = request.getParameter("name");
String password = request.getParameter("password");
String birthYear = request.getParameter("birthYear");
String gender = request.getParameter("gender");
String profile = request.getParameter("profile");

String[] hobbies = request.getParameterValues("hobby");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4><%=email%></h4>
	<h4><%=name%></h4>
	<h4><%=password%></h4>
	<h4><%=birthYear%></h4>
	<h4><%=gender%></h4>
	<p><%=profile%></p>

	<%
	for(String hobby:hobbies) {
	%>
	<h4><%=hobby%></h4>
	<%
	}
	%>

	<h6>
		email:<%=email%>,password:<%=password%>,birthYear:<%=birthYear%>,gender:<%=gender%></h6>
</body>
</html>