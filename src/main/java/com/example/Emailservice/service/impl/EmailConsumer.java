package com.example.Emailservice.service.impl;

import com.example.Emailservice.entity.EmailDetails;
import com.example.Emailservice.service.EmailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {

    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = "email-topic", groupId = "email-group")
    public void consume(String emailMessage) {
        // Add logic to send the email using the emailMessage
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            EmailDetails emailDetails = objectMapper.readValue(emailMessage, EmailDetails.class);
            emailService.sendSimpleMail(emailDetails);

        }catch (JsonProcessingException e) {
            // Handle the exception or log the error
            e.printStackTrace();
        }

//        System.out.println("Received email: " + emailMessage);
    }
}
