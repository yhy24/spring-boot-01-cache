package com.yang.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(basePackages = "com.yang.cache.mapper")
@EnableCaching
public class SpringBoot01CacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot01CacheApplication.class, args);
	}
}
