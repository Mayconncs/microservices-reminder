package com.microservices.reminder.dtos;

import com.microservices.reminder.domain.user.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
