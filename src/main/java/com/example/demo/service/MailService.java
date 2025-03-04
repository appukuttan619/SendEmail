package com.example.demo.service;

import jakarta.mail.AuthenticationFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class MailService {

    @Autowired
    JavaMailSender javaMailSender;

    public String sendMail(String to, String subject, String body){
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);

            javaMailSender.send(message);
            return "Send successfully";
        }catch (Exception e){
            System.out.println("Found Exception +++++++++++++++++++++++++++++");
            if(e.getCause() instanceof AuthenticationFailedException){
                System.out.println("hereeeee 0---------------09-----------");
                return "username and password is wrong";
            }
            System.out.println("hereee :::" + e.getCause() );
            return "Nope:" + e.getMessage();


        }

    }

}
