package servlet;

import dao.ArticleDaoMySql;
import dao.ThemeDaoMySql;
import model.Theme;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/article")
public class Article extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/WEB-INF/article.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        User user = (User) req.getSession().getAttribute("user");
        String theme = req.getParameter("theme");
        String text = req.getParameter("text");
        String name = req.getParameter("topic");

        Theme themeObject = new ThemeDaoMySql().findByTheme(theme);
        model.Article article = null;
        if (themeObject != null)
            article = model.Article.builder()
                    .themeId(themeObject.getThemeId())
                    .text(text)
                    .userId(user.getUserId())
                    .articleId(null)
                    .topic(name)
                    .build();
        if(article != null) {
            ArticleDaoMySql articleDaoMySql = new ArticleDaoMySql();
            articleDaoMySql.save(article);
        }
        resp.sendRedirect("home");
    }
}
