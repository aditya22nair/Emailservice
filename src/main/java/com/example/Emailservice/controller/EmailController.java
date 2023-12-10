package com.example.Emailservice.controller;

import com.example.Emailservice.entity.EmailDetails;
import com.example.Emailservice.service.EmailService;
import com.example.Emailservice.service.impl.EmailConsumer;
import com.example.Emailservice.service.impl.EmailProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmailProducer emailProducer;

    // Sending a simple Email
    @PostMapping("/sendMail")
    public String sendMail(@RequestBody EmailDetails details)
    {
//        String status = emailService.sendSimpleMail(details);
        emailProducer.sendEmail(details);

        return null;
    }

    // Sending email with attachment
    /*@PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(
            @RequestBody EmailDetails details)
    {
        String status
                = emailService.sendMailWithAttachment(details);

        return status;
    }*/
}

