<%@ page import="model.User" %>
<%@ page import="dao.UserDaoMySql" %>
<%@ page import="cookie.CookieUtils" %><%--
  Created by IntelliJ IDEA.
  User: ildar
  Date: 17.10.2020
  Time: 4:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
          integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900&display=swap" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
</head>
<body>
<header class=" bg-dark text-white logo" >
    <div class="d-flex align-items-center">
        <div class="">
            <a href="home" class="link-logo"><h1>NTech I.S.</h1></a>
        </div>
        <div class="btn-logout  ">
            <a href="logout">
                <button type="button" class = "btn btn-outline-light">Log out</button>
            </a>
        </div>

    </div>

</header>
<div class="container ">
    <div class="container mt-4 d-inline">
        <div><img src="https://sun9-48.userapi.com/xD2QrEjy9oEGx5ThYD974Prk5mrAEArpP_okcA/fTqgHpYSgzg.jpg" class="img200 imgProfile img-fluid rounded-circle" ></div>
        <div class="infoProfile ">
            <h4>Profile</h4>
            <table class="table table-th-block">
                <tbody>
                <%User user = new UserDaoMySql().findUserByEmail(CookieUtils.searchCookieByName(request.getCookies(), "login").getValue());%>
                <tr><td class="active">Login</td><td><%=user.getName()%></td></tr>
                <tr><td class="active">Age</td><td><%=user.getAge()%></td></tr>
                <tr><td class="active">City</td><td><%=user.getCountryId()%></td></tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
