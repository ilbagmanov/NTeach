<%@ page import="model.Article" %>
<%@ page import="java.util.List" %>
<%@ page import="util.CreateHTML" %><%--
  Created by IntelliJ IDEA.
  User: ildar
  Date: 02.11.2020
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div class="container">

    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
        <%=CreateHTML.createArticleCards(request)%>
    </div>
</div>