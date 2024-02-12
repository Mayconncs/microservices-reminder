package com.microservices.reminder.services;

import com.microservices.reminder.domain.reminder.Reminder;
import com.microservices.reminder.dtos.EmailRequestDTO;
import com.microservices.reminder.dtos.ReminderRequestDTO;
import com.microservices.reminder.exceptions.EmailSendingException;
import com.microservices.reminder.exceptions.ReminderNotFoundException;
import com.microservices.reminder.repositories.ReminderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ReminderService {
    @Autowired
    private ReminderRepository reminderRepository;

    @Autowired
    private EmailServiceClient emailServiceClient;

    public List<Reminder> getAllReminder() {
        return reminderRepository.findAll();
    }

    public List<Reminder> getUpcomingReminder() {
        return reminderRepository.findUpcomingReminder(LocalDateTime.now());
    }

    public Reminder createReminder(ReminderRequestDTO reminderRequestDTO) {
        Reminder reminder = new Reminder(reminderRequestDTO);
        EmailRequestDTO emailRequest = new EmailRequestDTO(
                reminder.getEmail(),
                reminder.getTitle(),
                reminder.getDetails()
        );
        emailServiceClient.sendEmail(emailRequest);

        return reminderRepository.save(reminder);
    }

    public Reminder updateReminderById(UUID id, ReminderRequestDTO reminderDTO) {
        Reminder reminder = reminderRepository.findById(id).
                orElseThrow(() -> new ReminderNotFoundException("Reminder not found"));

        BeanUtils.copyProperties(reminderDTO, reminder);
        reminderRepository.save(reminder);

        EmailRequestDTO emailRequestDTO = new EmailRequestDTO(
                reminderDTO.email(),
                reminderDTO.title(),
                reminderDTO.details()
        );
        try {
            emailServiceClient.sendEmail(emailRequestDTO);
        } catch (Exception ex) {
            throw new EmailSendingException("Failed to send email notification", ex);
        }

        return reminder;
    }

    public void deleteReminderById(UUID id) {
        reminderRepository.deleteById(id);
    }
}