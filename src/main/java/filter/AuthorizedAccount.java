package filter;

import util.Authorization;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/welcome", "/login"})
public class AuthorizedAccount implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String auth = (String) req.getSession().getAttribute("authorized");

        if(auth.equals("yes")) {
            resp.sendRedirect("home");
       } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
