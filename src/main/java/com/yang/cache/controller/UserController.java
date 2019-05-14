package com.yang.cache.controller;

import com.alibaba.fastjson.JSON;
import com.yang.cache.bean.User;
import com.yang.cache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author: yhy
 * @Date: 2019/5/14 9:20
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/saveUser")
    @ResponseBody
    public String inserUser() {
        System.out.println("************coming***********");
        User user = new User();
        user.setAge(21);
        user.setUsername("小白菜123");
        user.setPassword("125");
        user.setCode("1");
        user.setEmail("xiaobaicai7@qq.com");
        user.setInterest("打篮球_");
//        user.setCreateDate(new Date());
        user.setId(417);
        user.setPhone("9527");
        user.setSexly("g");
        userService.insertUser(user);
        System.out.println(user.toString());

        return JSON.toJSONString(user);
    }

    @RequestMapping(value = "/info",produces = "application/json;charset=utf-8",method = RequestMethod.GET)
    public String getUserInfo() {
        User user = new User();
        user.setId(2);
        user.setCode("1");
        User userInfo = userService.getUserInfo(user);
        return JSON.toJSONString(userInfo);
    }
}
