package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test")
public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        writer.write("<p1>Test Page</p1>");

        writer.write("<p>------------------------------------------</p>");

        //language=html
        writer.write("<h3>Cookie</h3>");

        Cookie[] cookies = req.getCookies();

        for(Cookie cookie : cookies) {
            writer.write("<p>"+ cookie.getName() + ":= " + cookie.getValue() + "</p>");
        }

        writer.write("<p>------------------------------------------</p>");

        writer.write("<h3>Attribute</h3>");
        writer.write("<p>" + req.getSession().getAttribute("authorized") + "</p>");

        writer.write("<p>" + req.getHeader("User-Agent").toString() + "</p>");

        writer.close();
    }
}
