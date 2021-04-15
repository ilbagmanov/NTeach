<%@ page import="model.Article" %>
<%@ page import="dao.ThemeDaoMySql" %>
<%@ page import="dao.UserDaoMySql" %>
<%@ page import="util.CreateHTML" %><%--
  Created by IntelliJ IDEA.
  User: ildar
  Date: 07.11.2020
  Time: 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Статья</title>
    <script src="../js/script.js"></script>
</head>
<body>
    <%Article article = (Article) request.getSession().getAttribute("article");%>
    <h1><%=article.getTopic()%></h1>
    <h2>Тег: <%=new ThemeDaoMySql().findByThemeId(article.getThemeId()).getTheme()%></h2>
    <h3>Автор: <%=new UserDaoMySql().findUserById(article.getUserId()).getName()%></h3>
    <h3>Дата: <%=article.getDate()%></h3>
    <form method="post" action="like"><button type="submit">Сохранить</button></form>
    <p><%=article.getText()%></p>
    <h3>Comments</h3>
    <%=CreateHTML.createCommentList(request)%>
    <h3>Add comment</h3>
    <form method="post" action="work">
        <div class="form-group">
            <label for="exampleFormControlTextarea1">Комментарий</label>
            <textarea minlength="10" maxlength="150" name="text" class="form-control" id="exampleFormControlTextarea1"
                      rows="3"></textarea>
        </div>
        <button type="submit">Отправить комментарий</button>
    </form>


<jsp:include page="template/__bootstrap-js.jsp"/>
</body>
</html>
