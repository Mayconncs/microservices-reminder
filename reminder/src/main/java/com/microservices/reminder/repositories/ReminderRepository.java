package com.microservices.reminder.repositories;

import com.microservices.reminder.domain.reminder.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder, UUID> {
    @Query(value = "SELECT * FROM reminder e WHERE to_timestamp(e.date, 'dd/MM/yyyy') >= :currentDate", nativeQuery = true)
    List<Reminder> findUpcomingReminder(@Param("currentDate") LocalDateTime currentDate);
}
