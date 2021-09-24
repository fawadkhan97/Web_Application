<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Create new User</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

</head>
<body>


<h1 style="text-align: center" class="mt-5">Add New User</h1>


<div style="text-align: center">
    <a class="btn btn-info" href="user-servlet">Home</a>
</div>


<div class="form-group mx-auto" style="width: 60%">
    <form action="insert" method="post">

        <label for="Username">Name: </label>
        <input class="form-control mb-3" type="text"  required name="name" id="userName"
        >


        <label for="Useremail">Email: </label>
        <input class="form-control mb-5" type="email"  required name="email" id="Useremail">


        <input class="btn btn-info"  onclick="onClick()" type="submit"/>

    </form>
</div>
<br/>

<script>

    function onClick(){

        let name = document.getElementById("userName");

        if(name.length > 1)
        alert("Your form has been submited");

    }

</script>


</body>
</html>