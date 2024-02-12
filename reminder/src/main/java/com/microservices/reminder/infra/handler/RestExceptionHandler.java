package com.microservices.reminder.infra.handler;

import com.microservices.reminder.exceptions.EmailSendingException;
import com.microservices.reminder.exceptions.ReminderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ReminderNotFoundException.class)
    private ResponseEntity<RestErrorMessage> ReminderNotFoundException(ReminderNotFoundException exception){
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatResponse);
    }

    @ExceptionHandler(EmailSendingException.class)
    private ResponseEntity<RestErrorMessage> EmailSendingException(EmailSendingException exception){
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(threatResponse);
    }

    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity<RestErrorMessage> runtimeErrorHandler(RuntimeException exception){
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(threatResponse);
    }
}
