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

<br>
<br>
<br>
<br>
<h1 style="text-align: center"  >Updating ${existinguser.name} info....</h1>

<br>
<div class="form-group mx-auto" style="width: 60%">
    <form action="update" method="post">
        <label for="Userid">ID: </label>
        <input class="form-control mb-3" type="number" readonly="true" name="id" id="Userid"
               value="<S:out value='${existinguser.id}' />">


        <label for="Username">Name: </label>
        <input class="form-control mb-3" type="text" name="name" id="userName"
               value="<S:out value='${existinguser.name}'/>">


        <label for="Useremail">Email: </label>
        <input class="form-control mb-5" type="email" name="email" id="Useremail" value="<S:out value='${existinguser.email}'/>">


        <input class="btn btn-info" type="submit"/>

    </form>
</div>
<br/>

<div style="text-align: center">
<a  class="btn btn-info" href="user-servlet">Home</a>
</div>
</body>
</html>