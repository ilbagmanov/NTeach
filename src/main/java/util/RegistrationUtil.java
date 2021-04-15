package util;

import cookie.CookieUtils;
import dao.UserDaoMySql;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class RegistrationUtil {
    static public boolean start(User user) throws IOException, ServletException {
        if (user == null) return false;
        User oldUser = new UserDaoMySql().findUserByEmail(user.getEmail());
        if (oldUser != null)
            return false;
        new UserDaoMySql().save(user);
        return true;
    }
}
