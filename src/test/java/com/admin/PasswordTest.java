package com.admin;

import com.mf.Tester;
import org.junit.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

public class PasswordTest extends Tester {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Test
    public void encodePassword() {
        String password = passwordEncoder.encode("123456");
        System.out.println(password);
    }
}
