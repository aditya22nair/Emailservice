package com.example.Emailservice.service;

import com.example.Emailservice.entity.EmailDetails;

public interface EmailService{
    String sendSimpleMail(EmailDetails details);
    String sendMailWithAttachment(EmailDetails details);


}