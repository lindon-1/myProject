package com.lindl.springbootcache;

import com.lindl.springbootcache.bean.Employee;
import com.lindl.springbootcache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCacheApplicationTests {
    @Resource
    EmployeeMapper employeeMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate<Object, Employee> empRedisTemplate;

    @Test
    public void contextLoads() {
        Employee empById = employeeMapper.getEmpById(1);
        System.out.println(empById);
    }

    @Test
    public void test1(){
//        Integer lindl = stringRedisTemplate.opsForValue().append("15251104144", "lindl");
//        System.out.println(lindl);
        String s = stringRedisTemplate.opsForValue().get("15251104144");
        System.out.println(s);

    }

    @Test
    public void test2(){
        Employee empById = employeeMapper.getEmpById(1);
        //redisTemplate.opsForValue().set("emp",empById);
        empRedisTemplate.opsForValue().set("emp01",empById);
    }

}

