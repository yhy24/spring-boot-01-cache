package com.yang.cache.shiroServer;

import com.alibaba.fastjson.JSON;
import com.yang.cache.bean.User;
import com.yang.cache.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: yhy
 * @Date: 2019/5/17 15:04
 * @Version 1.0
 */
@Component
public class BootShiroRealm extends AuthorizingRealm{

    @Autowired
    UserService userService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        SimpleAuthenticationInfo simpleInfo;
        String username = token.getUsername();
//        查询用户的信息
        User user = userService.getUserMessage(username);
        if (null == user) {
            System.out.println("用户的信息不存在的!");
            simpleInfo = new SimpleAuthenticationInfo("username", "password", getName());
        } else {
            simpleInfo = new SimpleAuthenticationInfo(username, user.getPassword(), getName());
//            System.out.println("*****验证的信息的使用******" + JSON.toJSONString(simpleInfo));
        }
        return simpleInfo;
    }
}
