package com.example.demo.controller;


import com.example.demo.model.MailRequest;
import com.example.demo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.SSLEngineResult;

@RestController
public class OtpGen {

    @Autowired
    MailService mailService;

    @GetMapping("/")
    public String hi(){
        return "hello world";
    }

    @PostMapping("/sendMail")
    public ResponseEntity<String> sendMail(@RequestBody MailRequest request){
        System.out.println(mailService.sendMail(request.getTo(), request.getSubject(), request.getBody()) + "-------------->");
        return ResponseEntity.ok("mail sent successfully");
    }


}
