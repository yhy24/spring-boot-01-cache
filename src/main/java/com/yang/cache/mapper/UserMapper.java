package com.yang.cache.mapper;

import com.yang.cache.bean.User;
import com.yang.cache.bean.UserDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: yhy
 * @Date: 2019/5/14 9:13
 * @Version 1.0
 */
public interface UserMapper {
    public void insertUser(User user);

    public User getUserInfo(User user);

    public int updateInfo(User user);

    public int deleteInfo(User user);

    public int deleteUser(UserDO userDO);
    public int deleteUserByIds(UserDO userDO);

    public int insertUsers(@Param("lists") List<User> lists);

    public User getUserMessage(@Param("userName") String userName);

}
