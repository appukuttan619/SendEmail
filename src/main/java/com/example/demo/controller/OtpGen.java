package com.example.demo.controller;


import com.example.demo.model.MailRequest;
import com.example.demo.service.MailService;
import com.example.demo.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.SSLEngineResult;
import java.util.Map;

@RestController
public class OtpGen {

    @Autowired
    MailService mailService;

    @Autowired
    OtpService otpService;

    @GetMapping("/")
    public String hi(){
        return "hello world";
    }

    @PostMapping("/sendMail")
    public ResponseEntity<String> sendMail(@RequestBody MailRequest request){
        System.out.println(mailService.sendMail(request.getTo(), request.getSubject(), request.getBody()) + "-------------->");
        return ResponseEntity.ok("mail sent successfully");
    }

    @GetMapping("/genOtp")
    public int genOtp(){
        return otpService.generateOTP();
    }

    @PostMapping("/sendOtpMail")
    public void sendOtpMail(@RequestBody Map<String, String> payload){
        otpService.sendOtpMail(payload.get("mail"));
    }

    @PostMapping("/verifyOtp")
    public boolean verifyOtp(@RequestBody Map<String, Integer> payload){
        System.out.println(payload.get("otp"));
        return otpService.verifyOtp(payload.get("otp"));
    }

}
