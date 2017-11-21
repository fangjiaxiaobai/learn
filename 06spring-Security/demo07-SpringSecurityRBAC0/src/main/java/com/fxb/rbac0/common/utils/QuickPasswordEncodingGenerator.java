package com.fxb.security.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author fangxiaobai
 * @date 2017/11/12 17:44.
 * @description QuickPasswordEncodingGenerator
 */
public class QuickPasswordEncodingGenerator {
    public static void main(String[] args) {
        String password = "123456";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode(password));
    }
}
