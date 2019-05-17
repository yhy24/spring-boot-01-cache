package com.yang.cache;

import com.yang.cache.intercepter.DataFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(basePackages = "com.yang.cache.mapper")
@EnableCaching
@ServletComponentScan(basePackageClasses = {DataFilter.class})  //进行过滤器的第二种使用方式（注解的形式）
public class SpringBoot01CacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot01CacheApplication.class, args);
	}
}
