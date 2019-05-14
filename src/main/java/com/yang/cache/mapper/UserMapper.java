package com.yang.cache.mapper;

import com.yang.cache.bean.User;

/**
 * @Author: yhy
 * @Date: 2019/5/14 9:13
 * @Version 1.0
 */
public interface UserMapper {
    public void insertUser(User user);

    public User getUserInfo(User user);


}
