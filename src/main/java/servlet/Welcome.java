package servlet;

import dao.ArticleDaoMySql;
import model.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/welcome")
public class Welcome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = (req.getParameter("id"));
        List<Article> articles;
        try {
            Integer integerId = null;
            integerId = Integer.parseInt(id);
            articles = new ArticleDaoMySql().findByThemeId(integerId);
        } catch (Exception e) {
            articles = new ArticleDaoMySql().findAll();
        }

        req.getSession().setAttribute("articles", articles);

        req.getServletContext().getRequestDispatcher("/WEB-INF/welcome.jsp").forward(req, resp);
    }
}
