package com.cloud.sso;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class SsoServerApplicationTests {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 加密
     */
    @Test
    void contextLoads() {
        System.out.println(passwordEncoder.encode("admin"));
    }

    /**
     * 原始密码匹配加密后的密码
     */
    @Test
    void equalsPassword() {
        String encodedPassword = "$2a$10$ty98SC.xHNTyg1mg4dhGPu8ORiosXNPLVaUd83Swxw0y6FcccQJq2";
//        String encodedPassword = "$2a$10$M7wQAswOWUJnYkVTlA1.c.EnM5BvJT2ZQ5G4sv.g7GtN8HtxC/W/W";
        System.out.println(passwordEncoder.matches(new String("admin"), encodedPassword));
    }

}
