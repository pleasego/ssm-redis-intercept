package com.xtkj.config;

import com.google.gson.Gson;
import com.xtkj.dao.RoleMapper;
import com.xtkj.pojo.Power;
import com.xtkj.pojo.Role;
import com.xtkj.pojo.User;
import com.xtkj.service.IJedisClient;
import com.xtkj.service.IPowerService;
import com.xtkj.service.IRoleService;
import com.xtkj.service.IUserService;
import com.xtkj.utilsTool.LoadEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Configuration
@Slf4j
public class RedisData {
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IPowerService powerService;
    @Autowired
    private IJedisClient jedisClient;

    private Gson gson = new Gson();


    @PostConstruct
    public void userLoad() {
        new Thread(() -> {
            log.debug("-----------启动线程开始缓存数据--------------");
            log.debug("---------------删除之前数据---------------");
            Set<String> keys1 = jedisClient.keys(LoadEnum.USER.getClazz() + "*");
            Iterator<String> iterator1 = keys1.iterator();
            while (iterator1.hasNext()) {
                String next = iterator1.next();
                long del = jedisClient.del(next);
            }
            log.debug("------------------删除完毕 开始缓存----------------");
            List<User> list1 = userService.list();
            for (User user : list1) {
                List<Role> roles = userService.getRoles(user.getUserId());
                user.setRoles(roles);
                String s = gson.toJson(user);
                jedisClient.hset(LoadEnum.USER.getClazz(), user.getUserId().toString(), s);
            }
            log.debug("------------------缓存完毕--------------------------");
        }).start();
    }

    @PostConstruct
    public void roleLoad() {
        new Thread(() -> {
            log.debug("-----------启动线程开始缓存数据--------------");
            log.debug("---------------删除之前数据---------------");
            Set<String> keys = jedisClient.keys(LoadEnum.ROLE.getClazz() + "*");
            Iterator<String> iterator = keys.iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                long del = jedisClient.del(next);
            }
            log.debug("------------------删除完毕 开始缓存----------------");
            List<Role> list = roleService.list();
            for (Role role : list) {
                List<Power> powers = roleService.getPowers(role.getRoleId());
                role.setPowers(powers);
                String s = gson.toJson(role);
                jedisClient.hset(LoadEnum.ROLE.getClazz(), role.getRoleId().toString(), s);
            }
            log.debug("------------------缓存完毕--------------------------");
        }).start();
    }

    @PostConstruct
    public void powerLoad() {
        new Thread(() -> {
            log.debug("-----------启动线程开始缓存数据--------------");
            log.debug("---------------删除之前数据---------------");
            Set<String> keys = jedisClient.keys(LoadEnum.POWER.getClazz() + "*");
            Iterator<String> iterator = keys.iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                long del = jedisClient.del(next);
            }
            log.debug("------------------删除完毕 开始缓存----------------");
            List<Power> list = powerService.list();
            for (Power power : list) {
                String s = gson.toJson(power);
                jedisClient.hset(LoadEnum.POWER.getClazz(), power.getPowerId().toString(), s);
            }
            log.debug("------------------缓存完毕--------------------------");
        }).start();
    }

}
