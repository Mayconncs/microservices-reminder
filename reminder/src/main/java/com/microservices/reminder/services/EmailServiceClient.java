package com.microservices.reminder.services;

import com.microservices.reminder.dtos.EmailRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "email", url = "http://localhost:8081/service/email")
public interface EmailServiceClient {
    @PostMapping("/send")
    void sendEmail(@RequestBody EmailRequestDTO emailRequestDTO);
}
