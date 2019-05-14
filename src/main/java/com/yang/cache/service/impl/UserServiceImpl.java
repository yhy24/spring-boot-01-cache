package com.yang.cache.service.impl;

import com.alibaba.fastjson.JSON;
import com.yang.cache.bean.User;
import com.yang.cache.mapper.UserMapper;
import com.yang.cache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author: yhy
 * @Date: 2019/5/14 9:16
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    @Cacheable(value = "test01",key = "'test_'+#user.id")
    public User getUserInfo(User user) {
        User userInfo = userMapper.getUserInfo(user);
        System.out.println("********--------:"+JSON.toJSONString(userInfo));
        return userInfo;
    }
}
