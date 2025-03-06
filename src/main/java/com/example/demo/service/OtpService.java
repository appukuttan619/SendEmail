package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OtpService {

    @Autowired
    MailService mailService;

    private  int genOtp;
    public int generateOTP(){
        Random random = new Random();
        return genOtp = random.nextInt(11111,100000);
    }

    public boolean verifyOtp(int otp){
        return otp == genOtp;
    }

    public void sendOtpMail(String mail) {
        String body = "OTP : " + genOtp + "Do not share with anyone";
        mailService.sendMail(mail, "Otp for verification", body);
    }
}
