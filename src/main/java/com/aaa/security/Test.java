package com.aaa.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String s = bCryptPasswordEncoder.encode("123");
        System.out.println(s);
    }
}
