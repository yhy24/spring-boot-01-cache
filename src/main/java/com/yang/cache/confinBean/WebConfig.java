package com.yang.cache.confinBean;

import com.yang.cache.intercepter.DataFilter;
import com.yang.cache.intercepter.PrivateIntercepter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
//    拦截器的使用
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(privateIntercepter()).addPathPatterns("/**");
    }
    @Bean
    public PrivateIntercepter privateIntercepter() {
        return new PrivateIntercepter();
    }
/*注册过滤器的使用*/
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterBean = new FilterRegistrationBean();
        filterBean.setFilter(new DataFilter());
        filterBean.addUrlPatterns("/*");
        filterBean.setName("dataFilter");
        filterBean.setOrder(0);
        return filterBean;
    }
}
