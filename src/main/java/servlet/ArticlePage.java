package servlet;

import dao.ArticleDaoMySql;
import dao.CommentDaoMySql;
import model.Article;
import model.Comment;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/work")
public class ArticlePage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ArticleDaoMySql articleDaoMySql = new ArticleDaoMySql();
        Article article = articleDaoMySql.findByArticleId(Integer.parseInt(id));
        req.getSession().setAttribute("article", article);
        req.getServletContext().getRequestDispatcher("/WEB-INF/article_page.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User user = (User) req.getSession().getAttribute("user");
        if(user != null) {
            Comment comment = Comment.builder()
                    .articleId(((Article)req.getSession().getAttribute("article")).getArticleId())
                    .userId(user.getUserId())
                    .comment(req.getParameter("text"))
                    .build();
            new CommentDaoMySql().save(comment);
            resp.sendRedirect("work?id=" + ((Article)req.getSession().getAttribute("article")).getArticleId());
        } else {
            resp.sendRedirect("work?id=" + ((Article)req.getSession().getAttribute("article")).getArticleId() + "&auth=false");
        }
    }
}
