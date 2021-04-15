package servlet;

import dao.CommentDaoMySql;
import dao.LikeDaoMySql;
import liquibase.pro.packaged.C;
import liquibase.pro.packaged.L;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/like")
public class Like extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/WEB-INF/like.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        model.Article article = (model.Article) req.getSession().getAttribute("article");
        LikeDaoMySql likeDaoMySql = new LikeDaoMySql();
        if(user != null && article != null && likeDaoMySql.findByUserIdAndArticleId(user.getUserId(), article.getArticleId()) == null) {
            model.Like like = model.Like.builder()
                    .userId(user.getUserId())
                    .articleId(article.getArticleId())
                    .build();
            likeDaoMySql.save(like);
        }
        if(article != null)
            resp.sendRedirect("work?id=" + article.getArticleId());
        else
            resp.sendRedirect("home");
    }
}
