package com.xtkj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xtkj.pojo.Power;
import com.xtkj.pojo.Role;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {

        List<Power> getPowers(Integer roleId);
}
