package com.xtkj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xtkj.dao.RoleMapper;
import com.xtkj.pojo.Power;
import com.xtkj.pojo.Role;
import com.xtkj.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Power> getPowers(Integer roleId) {
        return roleMapper.getPowers(roleId);
    }
}
