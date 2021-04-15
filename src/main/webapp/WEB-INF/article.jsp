<%@ page import="model.Theme" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.ThemeDaoMySql" %>
<%@ page import="util.CreateHTML" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Article</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

<div class="container">
    <div class="row" style="margin-top: 20px">
        <div class="col">
            <form method="post" action="article">
                <div class="form-group">
                    <label for="exampleFormControlInput1">Название</label>
                    <input maxlength="50" name="topic" type="text" class="form-control" id="exampleFormControlInput1"
                           placeholder="Игровая механика">
                </div>
                <div class="form-group">
                    <label for="exampleFormControlSelect1">Выберите тему</label>
                    <select name="theme" class="form-control" id="exampleFormControlSelect1">
                        <%=CreateHTML.createOptionsForArticle()%>
                    </select>
                </div>
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Статья</label>
                    <textarea maxlength="2000" name="text" class="form-control" id="exampleFormControlTextarea1"
                              rows="3"></textarea>
                </div>
                <button type="submit">Создать статью</button>
            </form>
        </div>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>

</body>
</html>
