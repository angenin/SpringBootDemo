package com.angenin.springboot.component;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @package_name: com.angenin.springboot.component
 * @name: LoginHandlerInterceptor
 * @author: angenin
 * @dateTime: 2020/12/13 下午1:50
 **/
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override   //目标方法执行之前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            //未登录，返回登录页面
            //保存错误信息
            request.setAttribute("msg", "没有权限，请先登录");
            //转发到登录页面
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        }else{
            //已登录，放行请求
            return true;
        }
    }
}