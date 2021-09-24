<%--
  Created by IntelliJ IDEA.
  User: fawad khan
  Date: 9/22/2021
  Time: 11:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.example.webapplication.User" %>
<%@page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome...</title>

    <base href="${pageContext.request.contextPath}">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>



<h1 class="mt-5" style="text-align: center"> Showing userList </h1>
<div class="m-3" style="text-align: center">
<a  href="${pageContext.request.contextPath}/showNewForm"  class="m btn btn-primary m-3 " role="button" >Add new user</a>
</div>

<div class="mt-5 mx-auto" style="width: 70%; text-align: center">
<table class="table" >
    <thead class="thead-dark">
    <tr>
        <th><b>ID</b></th>
        <th><b>Name</b></th>
        <th><b>email</b></th>
        <th><b>Actions</b></th>
    </tr>
    </thead>
    <%-- Fetching the attributes of the request object
         which was previously set by the servlet
          "StudentServlet.java"
    --%>
    <%
        ArrayList<User> userList = (ArrayList<User>) request.getAttribute("userList");
        for (User user : userList) {%>
    <%-- Arranging data in tabular form
    --%>
    <tr>
        <td><%=user.getId()%>
        </td>
        <td><%=user.getName()%>
        </td>
        <td><%=user.getEmail()%>
        </td>
        <td>
            <a href="${pageContext.request.contextPath}/delete ?id=<%=user.getId()%>"  class="btn btn-danger " role="button" >Delete</a>
            <a href="${pageContext.request.contextPath}/edit ?id=<%=user.getId()%>"  class="btn btn-secondary"  role="button" >Edit</a>
        </td>

    </tr>
    <%}%>
</table>

</div>
<hr/>

</body>
</html>
