package com.microservices.reminder.controllers;

import com.microservices.reminder.domain.reminder.Reminder;
import com.microservices.reminder.dtos.ReminderRequestDTO;
import com.microservices.reminder.services.ReminderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/reminder")
public class ReminderController {
    @Autowired
    private ReminderService reminderService;

    @GetMapping
    public ResponseEntity<List<Reminder>> getAllReminders() {
        List<Reminder> reminders = reminderService.getAllReminder();
        return ResponseEntity.ok(reminders);
    }

    @GetMapping("/upcoming")
    public ResponseEntity<List<Reminder>> getUpcomingReminders() {
        List<Reminder> reminders = reminderService.getUpcomingReminder();
        return ResponseEntity.ok(reminders);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Reminder> createReminder(@RequestBody ReminderRequestDTO reminderRequestDTO) {
        Reminder reminder = reminderService.createReminder(reminderRequestDTO);
        return new ResponseEntity<>(reminder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Reminder> updateById(@PathVariable UUID id, @RequestBody ReminderRequestDTO reminderRequestDTO) {
        Reminder reminder = reminderService.updateReminderById(id, reminderRequestDTO);
        return ResponseEntity.ok(reminder);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        reminderService.deleteReminderById(id);
        return ResponseEntity.noContent().build();
    }
}
