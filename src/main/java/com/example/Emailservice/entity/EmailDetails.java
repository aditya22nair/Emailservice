package com.example.Emailservice.entity;

import jdk.jfr.DataAmount;
import lombok.Data;

@Data
public class EmailDetails {
    private String recipient;
    private String subject;
    private String body;
    private EmailSource source;
}
