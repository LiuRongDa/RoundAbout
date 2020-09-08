package com.aaa.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author:
 * @time: 2020/9/8 9:40
 */
@Service
public class EmailSendUtils {
     @Autowired
     private JavaMailSenderImpl javaMailSender;

    @Value("${spring.mail.username}")
    private String from;
     //发送邮件
     public void sendSimple(String title,String msg,String userEmail){
         SimpleMailMessage message = new SimpleMailMessage();
         message.setSubject(title);
         message.setText(msg);
         message.setTo(userEmail);
         message.setFrom(from);
         javaMailSender.send(message);
     }
}
