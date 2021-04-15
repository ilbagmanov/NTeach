package servlet;

import dao.CountryDaoMySql;
import model.Country;
import model.User;
import util.Authorization;
import util.RegistrationUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class Registration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Country country = new CountryDaoMySql().findByName(req.getParameter("country"));
        int id = 1;
        if(country != null)
            id = country.getCountryId();
        User user = User.builder().name(req.getParameter("name"))
                .surname(req.getParameter("surname"))
                .email(req.getParameter("email"))
                .countryId(id)
                .age(Integer.valueOf(req.getParameter("age")))
                .password(req.getParameter("password")).build();
        if(RegistrationUtil.start(user)) {
            resp.sendRedirect("login");
        } else {
            resp.sendRedirect("register?email=false");
        }
    }
}
