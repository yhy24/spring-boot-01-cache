package com.yang.cache.confinBean;

import com.yang.cache.intercepter.DataFilter;
import com.yang.cache.intercepter.PrivateIntercepter;
import com.yang.cache.shiroServer.BootShiroRealm;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yhy
 * @Date: 2019/5/14 11:00
 * @Version 1.0
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.yang.cache.controller",
        "com.yang.cache.intercepter.**",
        "com.yang.cache.controller.**"})
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    BootShiroRealm bootShiroRealm;

//    拦截器的使用
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(privateIntercepter()).addPathPatterns("/**");
    }
    @Bean
    public PrivateIntercepter privateIntercepter() {
        return new PrivateIntercepter();
    }
/*注册过滤器的第一种方式的使用：使用@Bean的方式*/
    /*@Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterBean = new FilterRegistrationBean();
        filterBean.setFilter(new DataFilter());
        filterBean.addUrlPatterns("/*");
        filterBean.setName("dataFilter");
        filterBean.setOrder(0);
        return filterBean;
    }*/


    /*@Bean
    public BootShiroRealm bootShiroRealm() {
        return new BootShiroRealm();
    }
    */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(bootShiroRealm);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroBean = new ShiroFilterFactoryBean();
        shiroBean.setSecurityManager(securityManager);
        Map<String,String> map = new HashMap<String, String>();
/*        //登出
        map.put("/logout","logout");
        //对所有用户认证
        map.put("/**","authc");
        //登录
        shiroBean.setLoginUrl("/login");
        //首页
        shiroBean.setSuccessUrl("/index");
        //错误页面，认证不通过跳转
        shiroBean.setUnauthorizedUrl("/error");*/
        shiroBean.setFilterChainDefinitionMap(map);
        return shiroBean;
    }


}
