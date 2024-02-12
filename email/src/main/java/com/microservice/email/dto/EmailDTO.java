package com.microservice.email.dto;

import jakarta.validation.constraints.NotBlank;

public record EmailDTO(@NotBlank String to, String subject, String body) {
}