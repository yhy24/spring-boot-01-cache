package com.yang.cache;

import com.yang.cache.bean.Employee;
import com.yang.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot01CacheApplicationTests {
	@Autowired
	EmployeeMapper employeeMapper;

	@Autowired
	StringRedisTemplate stringRedisTemplate;
     @Autowired
	RedisTemplate redisTemplate;

	@Test
	public void contextLoads() {
		Employee byId = employeeMapper.getById(1);
		System.out.println(byId);
	}

	@Test
	public void test01() {
//        redisTemplate.opsForValue().append("msg", "yang hao ying");
        String msg = stringRedisTemplate.opsForValue().get("\\xAC\\xED\\x00\\x05t\\x00\\x03msg");
//        stringRedisTemplate.opsForValue().append("yang", "hao");
        String msg1 = stringRedisTemplate.opsForValue().get("yang");
        System.out.println(msg+"-------");
        System.out.println(msg1+"------------");
    }
}
