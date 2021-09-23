<%@ taglib prefix="S" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Create new User</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

</head>
<body>

<h1>Add New User</h1>
<form action="update" method="post">
    <table>
        <tr><td> Id: </td> <td> <input type="number" readonly="true"  name="id" value="<S:out value='${existinguser.id}' />"> </td> </tr>
        <tr><td>Name:</td><td><input type="text" name="name" value="<S:out value='${existinguser.name}'/>"></td></tr>
        <tr><td>Email:</td><td><input type="email" name="email"  value="<S:out value='${existinguser.email}'/>"></td></tr>
        <tr><td colspan="2"><input type="submit" /></td></tr>
    </table>
</form>

<br/>
<a href="user-servlet">Show Users</a>

</body>
</html>