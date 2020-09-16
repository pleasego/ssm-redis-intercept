package com.xtkj.service.impl;


import com.google.gson.Gson;
import com.xtkj.pojo.Role;
import com.xtkj.pojo.User;
import com.xtkj.service.IJedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.JedisPool;

import java.util.*;

@Transactional
@Component
public class JedisClientImpl implements IJedisClient {

    @Autowired
    private  JedisPool pool;

    @Override
    public String get(String key) {
        return pool.getResource().get(key);
    }

    @Override
    public String set(String key, String value) {
        return pool.getResource().set(key,value);
    }

    @Override
    public long ttl(String key) {
        return pool.getResource().ttl(key);
    }

    @Override
    public long expire(String key, int second) {
        return pool.getResource().expire(key,second);
    }

    @Override
    public long incr(String key) {
        return pool.getResource().incr(key);
    }

    @Override
    public long hset(String hkey, String key, String value) {
        return pool.getResource().hset(hkey,key,value);
    }

    @Override
    public String hget(String hkey, String key) {
        return pool.getResource().hget(hkey,key);
    }

    @Override
    public long del(String key) {
        return pool.getResource().del(key);
    }

    @Override
    public long hdel(String hkey, String key) {
        return pool.getResource().hdel(hkey,key);
    }

    @Override
    public Set<String> keys(String k) {
        return pool.getResource().keys(k);
    }

    @Override
    public List<Role> hGetRoleAll(String k) {
        List<Role> list = new ArrayList<>();
        Collection<String> values = pool.getResource().hgetAll(k).values();
        Iterator<String> iterator = values.iterator();
        while(iterator.hasNext()){
            Gson gson = new Gson();
            Role role = gson.fromJson(iterator.next(), Role.class);
            list.add(role);
        }
        return list;
    }

    @Override
    public List<User> hGetAll(String k) {
        List<User> list = new ArrayList<>();
        Collection<String> values = pool.getResource().hgetAll(k).values();
        Iterator<String> iterator = values.iterator();
        while(iterator.hasNext()){
            Gson gson = new Gson();
            User user = gson.fromJson(iterator.next(), User.class);
            list.add(user);
        }
        return list;
    }
}
