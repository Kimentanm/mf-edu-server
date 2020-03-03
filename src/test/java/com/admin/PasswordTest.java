package com.admin;

import com.mf.Tester;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

public class PasswordTest extends Tester {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void encodePassword() {
        String password = passwordEncoder.encode("123456");
        System.out.println(password);
    }

    @Test
    public void testRedis(){
        redisTemplate.opsForValue().set("key1","value1");
    }
}
