package com.xtkj.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import com.xtkj.pojo.Role;
import com.xtkj.pojo.User;
import com.xtkj.service.IJedisClient;
import com.xtkj.service.IUserService;
import com.xtkj.utilsTool.LoadEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IJedisClient jedisClient;

    private Gson gson = new Gson();

    /*@PostMapping("/checkLogin")
    public String checkLogin(String loginId, String loginPwd, HttpSession session){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("login_id",loginId)
                .eq("login_pwd",loginPwd);
        User one = userService.getOne(wrapper);
        if (one!=null)
            session.setAttribute("USER",one);
        return "{\"msg\":\"OK\"}";
    }*/

    @PostMapping("/checkLogin")
    public boolean checkLogin(String loginId, String loginPwd, HttpSession session){
      return  userService.checkLogin(loginId,loginPwd,session);
    }

    @GetMapping("aaa")
    public ModelAndView getPower1(){
        ModelAndView model = new ModelAndView();
        model.setViewName("WEB-INF/main/a");
        return model;
    }

    @GetMapping("bbb")
    public ModelAndView getPower2(){
        ModelAndView model = new ModelAndView();
        model.setViewName("WEB-INF/main/b");
        return model;
    }

    @GetMapping("ccc")
    public ModelAndView getPower3(){
        ModelAndView model = new ModelAndView();
        model.setViewName("WEB-INF/main/c");
        return model;
    }
}
