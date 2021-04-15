package filter;

import cookie.CookieUtils;
import dao.UserDaoMySql;
import model.User;
import util.Hash;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class MegaFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String check = (String) req.getSession().getAttribute("authorized");

        if (check == null) {
            Cookie[] cookies = req.getCookies();
            Cookie loginCookie = null;
            if(cookies != null)
                loginCookie = CookieUtils.searchCookieByName(req.getCookies(), "login");
            String login = null;
            String password = null;
            User user = null;
            if (loginCookie != null) {
                login = loginCookie.getValue();
                password = CookieUtils.searchCookieByName(req.getCookies(), "password").getValue();
                user = new UserDaoMySql().findUserByEmail(login);
            }
            try {
                if (user != null && user.getPassword().equals(Hash.hashPassword(password))) {
                    req.getSession().setAttribute("authorized", "yes");
                    req.getSession().setAttribute("user", user);
                }
                else
                    req.getSession().setAttribute("authorized", "no");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }


        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
