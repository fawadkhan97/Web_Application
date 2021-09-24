<%@page import="com.example.webapplication.User"%>
<%@page import="java.util.ArrayList"%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Management System</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<h1  >Welcome to Management System
</h1>
<br/>
<a  class="btn btn-info" href="hello-servlet">Hello Servlet</a>
<a class="btn btn-info"  href=" ${pageContext.request.contextPath}/user-servlet">User list</a>
</body>
</html>