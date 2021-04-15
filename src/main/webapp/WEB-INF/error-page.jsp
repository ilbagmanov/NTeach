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
    </div>

</header>
<div class="container ">
    <h1 style="text-align: center"><%=request.getAttribute("javax.servlet.error.status_code")%></h1>
</div>

</body>
</html>