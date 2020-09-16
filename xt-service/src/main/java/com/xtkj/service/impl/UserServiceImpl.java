package com.xtkj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xtkj.pojo.Role;
import com.xtkj.service.IJedisClient;
import com.xtkj.service.IUserService;
import com.xtkj.dao.UserMapper;
import com.xtkj.pojo.User;
import com.xtkj.utilsTool.LoadEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IJedisClient jedisClient;

    @Override
    public boolean checkLogin(String loginId, String loginPwd, HttpSession session) {
        List<User> users = jedisClient.hGetAll(LoadEnum.USER.getClazz());
        List<Role> roles = jedisClient.hGetRoleAll(LoadEnum.ROLE.getClazz());
        for (User user:users) {
            if(user.getLoginId().equals(loginId) && user.getLoginPwd().equals(loginPwd)){
                List<Role> roles1 = user.getRoles();
                List<Role> list = new ArrayList<>();
                for (Role role:roles1) {
                    for (Role role1:roles) {
                        if(role.getRoleId()==role1.getRoleId()){
                            list.add(role1);
                        }
                    }
                }
                user.setRoles(list);
                System.out.println(user);
                session.setAttribute("user",user);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Role> getRoles(Integer userId) {
        return userMapper.getUserRoleById(userId);
    }
}
