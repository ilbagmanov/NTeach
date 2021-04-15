<%@ page import="model.Article" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <a href="home" class="link-logo"><h1>NTech I.S.</h1></a>
        </div>
        <div class="btn-logout">
            <a href="logout">
                <button type="button" class="btn btn-outline-light">Log out</button>
            </a>
        </div>
        <div class="btn-success">
            <a href="profile">
                <button type="button" class="btn btn-outline-light">profile</button>
            </a>
        </div>
        <div class="btn-info">
            <a href="article">
                <button type="button" class="btn btn-outline-light">Create article</button>
            </a>
        </div>
        <div class="btn-info">
            <a href="mywork">
                <button type="button" class="btn btn-outline-light">My work</button>
            </a>
        </div>
        <div class="btn-info">
            <a href="like">
                <button type="button" class="btn btn-outline-light">Favourites</button>
            </a>
        </div>
        <div class="btn-info">
            <a href="contacts">
                <button type="button" class="btn btn-outline-light">Contacts</button>
            </a>
        </div>

    </div>

</header>
<div class="container ">
    <jsp:include page="template/__main-menu-articles-types.jsp" />
    <jsp:include page="template/__main-menu-articles-list.jsp" />
</div>

</body>
</html>