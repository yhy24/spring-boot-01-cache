package com.yang.cache.service;

import com.yang.cache.bean.User;
import com.yang.cache.bean.UserDO;

import java.util.List;

/**
 * @Author: yhy
 * @Date: 2019/5/14 9:16
 * @Version 1.0
 */
public interface UserService {
    public User insertUser(User user);
    public User getUserInfo(User user);

    public int deleteUser(User user);

    public User updateUser(User user);
    public int deleteUser(UserDO userDO);
    public int deleteUserByIds(UserDO userDO);
    public int insertUsers(List<User> lists);
}
