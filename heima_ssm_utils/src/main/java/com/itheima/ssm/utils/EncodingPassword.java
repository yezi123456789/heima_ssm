package com.itheima.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class EncodingPassword {
    private static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String s = encodePassword("123"); //$2a$10$TOcVXjQoXILyFhZ.4ROc8OsHtWO84SgIZzTwemnGMcEYH7NXu4Z5G
        System.out.println(s);
    }
}
