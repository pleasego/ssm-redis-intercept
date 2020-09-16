package com.xtkj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xtkj.pojo.Role;
import com.xtkj.pojo.User;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface IUserService extends IService<User> {

    boolean checkLogin(String loginId, String loginPwd, HttpSession session);

    List<Role> getRoles(Integer userId);
}
