<%@page import="com.example.webapplication.User"%>
<%@page import="java.util.ArrayList"%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP -  World</title>
</head>
<body>
<h1  ><%= "List of users" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<a href=" ${pageContext.request.contextPath}/user-servlet">User list</a>
</body>
</html>