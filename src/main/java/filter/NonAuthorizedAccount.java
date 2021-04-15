package filter;

import util.Authorization;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/home", "/profile", "/article", "/like", "/mywork"})
public class NonAuthorizedAccount implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String auth = (String) req.getSession().getAttribute("authorized");

        if(auth.equals("no")) {
            resp.sendRedirect("welcome");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
