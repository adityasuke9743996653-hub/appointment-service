package com.example.appointment_service.DTO;

import lombok.Data;

@Data
public class NotificationDTO {
    private String recipient;
    private String subject;
    private String message;

    // getters and setters
}


