<%@ page import="util.CreateHTML" %><%--
  Created by IntelliJ IDEA.
  User: ildar
  Date: 07.11.2020
  Time: 4:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Мои статьи</title>
</head>
<body>
<h1>Мои статьи</h1>
<%=CreateHTML.createMyArticles(request)%>
</body>
</html>
