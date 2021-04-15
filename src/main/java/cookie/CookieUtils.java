package cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
    public static Cookie searchCookieByName(Cookie[] cookies, String key) {
        if (cookies != null && key != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(key)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    public static boolean checkCookieByValue (Cookie cookie, String value) {

        if(cookie == null || value == null) return false;

        return cookie.getValue().equals(value);
    }

    public static void delete (HttpServletResponse resp, String key) {
        Cookie cookie = new Cookie(key, "");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
    }

    public static void add (HttpServletResponse resp, String key, String value, boolean saveMe) {
        Cookie cookie = new Cookie(key, value);
        if (saveMe)
            cookie.setMaxAge(60 * 60 * 24 * 7);
        else
            cookie.setMaxAge(-1);
        resp.addCookie(cookie);
    }
}
