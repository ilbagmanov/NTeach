<%@ page import="util.CreateHTML" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Log in</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
          integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900&display=swap" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/signin.css" rel="stylesheet">
</head>
<body class="text-center">

<form class="form-signin" method="post" action="register">

    <h1 class="h3 mb-3 font-weight-normal">Register</h1>
    <label for="inputEmail" class="sr-only">Email</label>
    <input name="email" type="email" id="inputEmail" class="form-control" placeholder="Email" required autofocus>
    <label for="inputName" class="sr-only">Name</label>
    <input name="name" type="text" id="inputName" class="form-control" placeholder="Name" required autofocus>
    <label for="inputSurname" class="sr-only">Surname</label>
    <input name="surname" type="text" id="inputSurname" class="form-control" placeholder="Surname" required autofocus>
    <label for="inputCountry" class="sr-only">Country</label>
    <select name="country" id="inputCountry" required autofocus class="form-control" id="exampleFormControlSelect1">
        <%=CreateHTML.createOptionsForRegister()%>
    </select>
    <label for="inputAge" class="sr-only">Age</label>
    <input name="age" type="number" id="inputAge" class="form-control" placeholder="Age" required autofocus>
    <label for="inputPassword" class="sr-only">Password</label>
    <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
    <label for="inputPassword" class="sr-only">Repeat Password</label>
    <input type="password" id="repeatInputPassword" class="form-control" placeholder="Repeat password" required>
    <button class="btn btn-lg btn-dark btn-block" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted">NTech I.S.</p>
</form>


</body>
</html>
