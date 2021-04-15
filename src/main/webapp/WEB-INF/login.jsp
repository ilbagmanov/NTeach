<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Log in</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
          integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900&display=swap" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/signin.css" rel="stylesheet">
    <jsp:include page="template/__bootstrap-js.jsp"/>
    <script src="../js/invalidpass.js"></script>
</head>
<body class="text-center" onload="invalidPassword()">

<form class="form-signin" method="post" action="login">

    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
    <label for="inputEmail" class="sr-only">Email address</label>
    <input name="login" type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
    <label for="inputPassword" class="sr-only">Password</label>
    <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
    <span class="error" style="visibility: hidden; font-size: 12px; color: darkred">ошибка при вводе логина или пароля</span>
    <div class="checkbox mb-3">
        <label>
            <input name="check" type="checkbox"> Remember me
        </label>
    </div>
    <button class="btn btn-lg btn-dark btn-block" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted">NTech I.S.</p>
</form>

</body>
</html>
