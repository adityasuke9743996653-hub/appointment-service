package com.example.appointment_service.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long patientId;
    private String patientName;
    private String patientContactNumber;
    private String patientEmailId;
    private Long doctorId;
    private String doctorName;
    private String doctorSpecialization;
    private String doctorContactNumber;
    private String doctorEmailId;

    private LocalDateTime appointmentDateTime;

    //private String status; // e.g., SCHEDULED, COMPLETED, CANCELLED
}
