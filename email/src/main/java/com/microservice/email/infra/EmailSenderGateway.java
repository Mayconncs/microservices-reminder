package com.microservice.email.infra;

public interface EmailSenderGateway {
    void sendEmail(String to, String subject, String body);
}
