package util;

import cookie.CookieUtils;
import dao.MySqlConnection;
import dao.UserDaoMySql;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Authorization {

    static public boolean start(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String checkbox = req.getParameter("check");

        if (checkAuth(login, password)) {
            User user = new UserDaoMySql().findUserByEmail(login);
            req.getSession().setAttribute("user", user);
            CookieUtils.add(resp, "login", login, checkbox != null && checkbox.equals("on"));
            CookieUtils.add(resp, "password", password, checkbox != null && checkbox.equals("on"));
            req.getSession().setAttribute("authorized", "yes");
            return true;
        } else {
            return false;
        }
    }

    static public boolean checkAuth(String login, String password) {
        User user = new UserDaoMySql().findUserByEmail(login);
        try {
            return user != null && user.getPassword().equals(Hash.hashPassword(password));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    static public void logout (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        CookieUtils.delete(resp, "login");
        CookieUtils.delete(resp, "password");
        req.getSession().setAttribute("authorized", "no");
        req.getSession().setAttribute("user", null);
    }
}
