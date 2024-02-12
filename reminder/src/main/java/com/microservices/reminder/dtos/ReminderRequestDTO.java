package com.microservices.reminder.dtos;

public record ReminderRequestDTO(String title, String email, String details, String date) {

}
