package com.xtkj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xtkj.pojo.Power;
import com.xtkj.pojo.Role;

import java.util.List;

public interface IRoleService extends IService<Role> {

    List<Power> getPowers(Integer roleId);
}
