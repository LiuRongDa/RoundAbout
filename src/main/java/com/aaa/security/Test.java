package com.aaa.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

    public static void main(String[] args) {
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        String encode = bCrypt.encode("123");
        System.out.println(encode);
    }
}
