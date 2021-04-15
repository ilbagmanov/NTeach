<%@ page import="util.CreateHTML" %><%--
  Created by IntelliJ IDEA.
  User: ildar
  Date: 07.11.2020
  Time: 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Любимые</title>
</head>
<body>
<h1>Любимые статьи</h1>
<%=CreateHTML.createLikeArticle(request)%>
</body>
</html>
