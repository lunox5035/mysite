<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String name= request.getParameter("name");

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Hello
		<%=name %></h1>
	<h2>1</h2>
	<h3>2</h3>
	<img src="./cat.jpg" style="width: 500px" />
</body>
</html>