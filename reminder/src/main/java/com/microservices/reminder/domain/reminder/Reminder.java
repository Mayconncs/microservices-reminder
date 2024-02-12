package com.microservices.reminder.domain.reminder;

import com.microservices.reminder.dtos.ReminderRequestDTO;
import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity(name="reminder")
@Table(name="reminder")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Reminder {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String email;
    private String details;
    private String date;

    public Reminder(ReminderRequestDTO reminderRequestDTO){
        this.title = reminderRequestDTO.title();
        this.email = reminderRequestDTO.email();
        this.details = reminderRequestDTO.details();
        this.date = reminderRequestDTO.date();
    }
}
