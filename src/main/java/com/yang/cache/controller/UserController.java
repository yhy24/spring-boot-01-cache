package com.yang.cache.controller;

import com.alibaba.fastjson.JSON;
import com.yang.cache.bean.User;
import com.yang.cache.bean.UserDO;
import com.yang.cache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @RequestMapping(value = "/saveUser",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String inserUser(@RequestBody User user) {
        System.out.println("************coming***********"+JSON.toJSONString(user));
       /* User user = new User();
        user.setAge(21);
        user.setUsername("小白菜zl");
        user.setPassword("125");
        user.setCode("1");
        user.setEmail("xiaobaicai7@qq.com");
        user.setInterest("打篮球zl");
//        user.setCreateDate(new Date());
        user.setId(419);
        user.setPhone("9527zwn");
        user.setSexly("g");*/
        userService.insertUser(user);
        System.out.println(user.toString());

        return JSON.toJSONString(user);
    }

    @RequestMapping(value = "/info",produces = "application/json;charset=utf-8",method = RequestMethod.POST)
    public String getUserInfo(@RequestBody User user) {
        System.out.println("************coming***********"+JSON.toJSONString(user));
        /*User user = new User();
        user.setId(417);
        user.setCode("1");*/
        User userInfo = userService.getUserInfo(user);
        return JSON.toJSONString(userInfo);
    }

    @RequestMapping(value = "/deleteInfo",method = RequestMethod.POST)
    public String deleteUser(@RequestBody User user){
        System.out.println("************coming***********"+JSON.toJSONString(user));
       /* User user = new User();
        user.setAge(21);
        user.setUsername("小白菜123");
        user.setPassword("125");
        user.setCode("1");
        user.setEmail("xiaobaicai7@qq.com");
        user.setInterest("打篮球_");
//        user.setCreateDate(new Date());
        user.setId(417);
        user.setPhone("9527");
        user.setSexly("g");*/
        int i = userService.deleteUser(user);
        return JSON.toJSONString(i);
    }
    @RequestMapping(value = "/updateInfo",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String updateUser(@RequestBody User user) {
        System.out.println("************coming***********"+JSON.toJSONString(user));
       /* User user = new User();
        user.setAge(23);
        user.setUsername("小白菜yhy");
        user.setPassword("1256");
        user.setCode("1");
        user.setEmail("xiaobaicai7@qq.com");
        user.setInterest("打篮球test");
//        user.setCreateDate(new Date());
        user.setId(417);
        user.setPhone("9527");
        user.setSexly("g");*/
        User user1 = userService.updateUser(user);
        return JSON.toJSONString(user1);
    }
    @RequestMapping(value = "/deleteByl",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String deleteUserL(@RequestBody UserDO userDO) {
        System.out.println("****cmoing*******"+JSON.toJSONString(userDO));
        int i = userService.deleteUser(userDO);
        return JSON.toJSONString(i);
    }

    @RequestMapping(value = "/deleteByS",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String deleteUserS(@RequestBody UserDO userDO) {
        System.out.println("****cmoing*******"+JSON.toJSONString(userDO));
        int i = userService.deleteUserByIds(userDO);
        return JSON.toJSONString(i);
    }

    @RequestMapping(value = "/insertUsers",produces = "application/json;charset=utf-8")
    public String insertUsers() {
        List<User> lists = new ArrayList<>();
        User user = new User();
        user.setCode("1");
        user.setId(532);
        user.setUsername("小白兔");
        user.setMark("批量添加");
        User user1 = new User();
        user1.setCode("1");
        user1.setId(533);
        user1.setUsername("小白兔~~~");
        user1.setMark("批量添加~test");
        lists.add(user);
        lists.add(user1);
        int i = userService.insertUsers(lists);
        return JSON.toJSONString(i);
    }







}
