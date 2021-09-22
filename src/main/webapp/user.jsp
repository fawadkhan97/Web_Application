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
    <title>Welcome...e</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link href="./css/style.css" rel="stylesheet" type="text/css">
</head>
<body>




<h1> List of user </h1>

<table >
    <thead>
    <tr>
        <th><b>  ID</b></th>
        <th><b> Name</b></th>
        <th><b>email</b></th>
    </tr>
    </thead>
    <%-- Fetching the attributes of the request object
         which was previously set by the servlet
          "StudentServlet.java"
    --%>
    <%
        ArrayList<User> userList = (ArrayList<User>) request.getAttribute("data");
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

    </tr>
    <%}%>
</table>
<hr/>

</body>
</html>
