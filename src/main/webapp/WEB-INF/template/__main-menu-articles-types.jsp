<%@ page import="dao.UserDaoMySql" %>
<%@ page import="dao.ArticleDaoMySql" %>
<%@ page import="dao.ThemeDaoMySql" %>
<%@ page import="model.Theme" %>
<%@ page import="java.util.List" %>
<%@ page import="util.CreateHTML" %><%--
  Created by IntelliJ IDEA.
  User: ildar
  Date: 02.11.2020
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div class="my-navbar">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <%=CreateHTML.createArticleTypes()%>
            </ul>
        </div>
    </nav>
</div>