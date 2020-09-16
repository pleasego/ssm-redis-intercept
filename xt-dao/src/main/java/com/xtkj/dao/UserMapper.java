package com.xtkj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xtkj.pojo.Role;
import com.xtkj.pojo.User;

import java.util.List;


public interface UserMapper extends BaseMapper<User> {

    List<Role> getUserRoleById(Integer userId);

    User checkLogin(String loginId, String loginPwd);
}
