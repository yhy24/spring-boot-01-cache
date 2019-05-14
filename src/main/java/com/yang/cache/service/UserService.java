package com.yang.cache.service;

import com.yang.cache.bean.User;

/**
 * @Author: yhy
 * @Date: 2019/5/14 9:16
 * @Version 1.0
 */
public interface UserService {
    public void insertUser(User user);
    public User getUserInfo(User user);
}
