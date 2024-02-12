package com.microservice.email.controller;

import com.microservice.email.dto.EmailDTO;
import com.microservice.email.service.EmailSenderService;
import com.microservice.email.exception.EmailException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/email")
public class EmailController {
    private final EmailSenderService emailSenderService;

    @Autowired
    public EmailController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody @Valid EmailDTO emailDTO) {
        try {
            emailSenderService.sendEmail(emailDTO.to(), emailDTO.subject(), emailDTO.body());
            return ResponseEntity.ok("Email sent successfully");
        } catch (EmailException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email sending failed");
        }
    }
}

