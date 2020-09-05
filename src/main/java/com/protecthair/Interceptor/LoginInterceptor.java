package com.protecthair.Interceptor;//package com.com.liuquan.Interceptor;

import com.protecthair.domain.SessionUser;
import com.protecthair.util.SessionUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        SessionUser sessionUser = SessionUtil.getSessionUserFromCookie(httpServletRequest);
        if (sessionUser == null){
            //重定向到登录页面
            httpServletResponse.sendRedirect("/pages/user/login.html");
            return false;
        }else{
        return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }


    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
