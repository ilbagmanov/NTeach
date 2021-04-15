package util;

import dao.*;
import liquibase.pro.packaged.L;
import model.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CreateHTML {
    public static String createArticleCards(HttpServletRequest request) {
        List<Article> list = (List<Article>) request.getSession().getAttribute("articles");

        String ans = "";
        if (list != null)
            for (Article article : list) {

                String text = article.getText();
                if (text.length() > 46)
                    text = text.substring(0, 45);
                //language=HTML
                ans +=
                        "<div class=\"col\">\n" +
                        "   <div class=\"card shadow-sm\">\n" +
                        "       <svg class=\"bd-placeholder-img card-img-top\" width=\"100%\" height=\"225\"\n" +
                        "           xmlns=\"http://www.w3.org/2000/svg\" aria-label=\"Placeholder: Thumbnail\"\n" +
                        "           preserveAspectRatio=\"xMidYMid slice\" role=\"img\" focusable=\"false\"><title>Placeholder</title>\n" +
                        "           <rect width=\"100%\" height=\"100%\" fill=\"#55595c\"/>\n" +
                        "           <text x=\"50%\" y=\"50%\" fill=\"#eceeef\" dy=\".3em\">Thumbnail</text>\n" +
                        "       </svg>\n" +
                        "\n" +
                        "       <div class=\"card-body\">\n" +
                        "           <h5>" + article.getTopic() + "</h5>\n" +
                        "               <p class=\"card-text\">" + text + "..." + "</p>\n" +
                        "               <div class=\"d-flex justify-content-between align-items-center\">\n" +
                        "                   <div class=\"btn-group\">\n" +
                        "                       <a href=\"work?id=" + article.getArticleId() + "\"" +
                        "                           <button type=\"button\" class=\"btn btn-sm btn-outline-secondary\">View</button>\n" +
                        "                       </a>" +
                        "                   </div>\n" +
                        "                   <small class=\"text-muted\">" + article.getDate() + "</small>\n" +
                        "               </div>\n" +
                        "       </div>\n" +
                        "   </div>\n" +
                        "</div>";
            }
        return ans;
    }

    public static String createArticleTypes() {
        ThemeDaoMySql themeDaoMySql = new ThemeDaoMySql();
        List<Theme> list = themeDaoMySql.findAll();
        //language=HTML
        String ans =
                "<li class=\"nav-item\">" +
                "     <a class=\"nav-link\" href=\"?id=\">Всё</a>" +
                "</li>";
        for (Theme theme : list) {
            //language=HTML
            ans +=
                    "<li class=\"nav-item\">\n" +
                    "   <a class=\"nav-link\" href=\"?id=" + theme.getThemeId() + "\">" + theme.getTheme() + "</a>\n" +
                    "</li>";
        }
        return ans;
    }

    public static String createOptionsForArticle() {
        List<Theme> list = new ThemeDaoMySql().findAll();
        String ans = "";
        for (Theme theme : list) {
            ans += "<option>" + theme.getTheme() + "</option>";
        }
        return ans;
    }

    public static String createOptionsForRegister() {
        List<Country> list = new CountryDaoMySql().findAll();
        String ans = "";
        for (Country country : list) {
            ans += "<option>" + country.getCountry() + "</option>";
        }
        return ans;
    }

    public static String createCommentList(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Comment> list = new CommentDaoMySql().findByArticleId(id);
        String ans = "";
        for(Comment comment : list) {
            //language=HTML
            ans += "<p style='border-top: 1px black solid'>Email:" + new UserDaoMySql().findUserById(comment.getUserId()).getEmail() + "</p>";
            ans += "<p>Время:" + comment.getDate() + "</p>";
            ans += "<p>" + comment.getComment() + "</p>";
        }
        return ans;
    }

    public static String createLikeArticle(HttpServletRequest request) {
        LikeDaoMySql likeDaoMySql = new LikeDaoMySql();
        List<Like> likes = likeDaoMySql.findByUserId(((User)request.getSession().getAttribute("user")).getUserId());
        String ans = "";
        ArticleDaoMySql articleDaoMySql = new ArticleDaoMySql();
        for(Like like : likes) {
            Article article = articleDaoMySql.findByArticleId(like.getArticleId());
            //language=HTML
            ans += "<a href='work?id=" + article.getArticleId() + "'><p>" + article.getTopic() + "</p></a>";
        }
        return ans;
    }

    public static String createMyArticles(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        ArticleDaoMySql articleDaoMySql = new ArticleDaoMySql();
        List<Article> articles = articleDaoMySql.findByUserId(user.getUserId());
        String ans = "";
        for(Article article : articles) {
            ans += "<a href='work?id=" + article.getArticleId() + "'><p>_" + article.getTopic() + "_</p></a>";
        }
        return ans;
    }
}
