package com.example.email.controller;

import com.example.email.constant.MyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sendSimpleEmail")
public class SimpleEmailExampleController {

    @Autowired
    public JavaMailSender emailSender;

    @GetMapping
    public ResponseEntity<?> sendSimpleEmail() {

        try {
            // Create a Simple MailMessage.
            SimpleMailMessage message = new SimpleMailMessage();

            message.setTo(MyConstants.FRIEND_EMAIL);
            message.setSubject("Test Simple Email");
            message.setText("Hello, Im testing Simple Email");

            // Send Message!

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
