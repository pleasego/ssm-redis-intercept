package com.xtkj.interceptor;

import com.xtkj.pojo.Power;
import com.xtkj.pojo.Role;
import com.xtkj.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        if(user == null){
            response.getWriter().print("{\"msg\":\"认证失效，请重新登录\"}");
            return false;
        }
        if(user!=null){
            User u = (User) user;
            List<Role> roles = u.getRoles();
            for (Role role:roles) {
                List<Power> powers = role.getPowers();
                for (Power power:powers) {
                    if(request.getRequestURL().toString().contains(power.getPowerName())){
                        return true;
                    }
                }
            }
        }
        response.getWriter().print("{\"msg\":\"没有访问权限\"}");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
