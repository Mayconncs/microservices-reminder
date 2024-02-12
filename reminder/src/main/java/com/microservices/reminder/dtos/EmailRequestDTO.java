package com.microservices.reminder.dtos;

public record EmailRequestDTO(String to, String subject, String body) {

}
