package com.xtkj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xtkj.dao.PowerMapper;
import com.xtkj.pojo.Power;
import com.xtkj.service.IPowerService;
import org.springframework.stereotype.Service;

@Service
public class PowerServiceImpl extends ServiceImpl<PowerMapper, Power> implements IPowerService {
}
