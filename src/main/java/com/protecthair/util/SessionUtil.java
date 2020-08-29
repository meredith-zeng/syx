package com.protecthair.util;

import com.protecthair.domain.SessionUser;
import com.protecthair.result.Constant;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author by liuquan
 * @Classname SessionUtil
 * @Description TODO
 * @Date 2020/8/20 16:11
 */
public class SessionUtil {
    public static SessionUser getSessionUserFromCookie(HttpServletRequest request) {
        //获取cookie
        String token = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(Constant.COOKIE_TOKEN_NAME)) {
                    token = cookie.getValue();
                }
            }
        }
        //获取session
        HttpSession session = request.getSession();
        SessionUser sessionUser = (SessionUser) session.getAttribute(token);
        return sessionUser;
    }
}
