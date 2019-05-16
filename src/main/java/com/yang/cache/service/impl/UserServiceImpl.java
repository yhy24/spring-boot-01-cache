package com.yang.cache.service.impl;

import com.alibaba.fastjson.JSON;
import com.yang.cache.bean.User;
import com.yang.cache.bean.UserDO;
import com.yang.cache.mapper.UserMapper;
import com.yang.cache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yhy
 * @Date: 2019/5/14 9:16
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

/*添加用户信息进行缓存*/
    @Override
    @CachePut(value = "redisCache",key = "'ISC_USER.'+#user.id")
    public User insertUser(User user) {
        userMapper.insertUser(user);
        return user;
    }
/*注解进行缓存数据*/
    @Override
    @Cacheable(value = "redisCache",key = "'ISC_USER.'+#user.id")
    public User getUserInfo(User user) {
        System.out.println("************"+user.toString());
        System.out.println("********--------:"+JSON.toJSONString(userMapper.getUserInfo(user)));
        return userMapper.getUserInfo(user);
    }

    /*进行缓存的清除*/
    @Override
    @CacheEvict(value = "redisCache", key = "'ISC_USER.'+#user.id")
    public int deleteUser(User user) {
        return userMapper.deleteInfo(user);
    }

    @Override
    @CachePut(value = "redisCache", key = "'ISC_USER.'+#user.id")
    public User updateUser(User user) {
        userMapper.updateInfo(user);
        return userMapper.getUserInfo(user);
    }

    @Override
    public int deleteUser(UserDO userDO) {
        return userMapper.deleteUser(userDO);
    }

    @Override
    public int deleteUserByIds(UserDO userDO) {
        return userMapper.deleteUserByIds(userDO);
    }

    @Override
    public int insertUsers(List<User> lists) {
        return userMapper.insertUsers(lists);
    }

}
