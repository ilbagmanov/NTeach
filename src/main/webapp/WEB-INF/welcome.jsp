<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>Ntech I.O.</title>
    <jsp:include page="template/__bootstrap-css.jsp"/>
    <link href="../css/style.css" rel="stylesheet">
</head>
<body>
<header class=" bg-dark text-white logo">
    <div class="d-flex align-items-center">
        <div class="">
            <a href="welcome" class="link-logo"><h1>NTech I.S.</h1></a>
        </div>
        <div class="btn-logout">
            <a href="login" style="margin-left: 10px">
                <button type="button" class="btn btn-outline-light">Log in</button>
            </a>
        </div>
        <div class="btn-logout  ">
            <a href="register">
                <button type="button" class="btn btn-outline-light">Register</button>
            </a>
        </div>

    </div>

</header>
<div class="container ">
    <jsp:include page="template/__main-menu-articles-types.jsp" />

    <jsp:include page="template/__main-menu-articles-list.jsp"/>
</div>

</body>
</html>