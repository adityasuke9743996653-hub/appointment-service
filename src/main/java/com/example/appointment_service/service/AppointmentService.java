package com.example.appointment_service.service;

import com.example.appointment_service.entity.Appointment;
import com.example.appointment_service.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    // Create appointment
    public Appointment create(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    // Get all appointments
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    // Get appointment by ID
    public Optional<Appointment> getById(Long id) {
        return appointmentRepository.findById(id);
    }

    // Update appointment
    public Appointment update(Long id, Appointment appointmentDetails) {
        Appointment existing = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with ID: " + id));
        existing.setAppointmentDateTime(appointmentDetails.getAppointmentDateTime());
        existing.setPatientName(appointmentDetails.getPatientName());
        existing.setPatientContactNumber(appointmentDetails.getPatientContactNumber());
        existing.setPatientEmailId(appointmentDetails.getPatientEmailId());
        existing.setDoctorName(appointmentDetails.getDoctorName());
        existing.setDoctorSpecialization(appointmentDetails.getDoctorSpecialization());
        existing.setDoctorContactNumber(appointmentDetails.getDoctorContactNumber());
        existing.setDoctorEmailId(appointmentDetails.getDoctorEmailId());
       

        return appointmentRepository.save(existing);
    }

    // Delete appointment
    public void delete(Long id) {
        Appointment existing = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with ID: " + id));
        appointmentRepository.delete(existing);
    }
    
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
    }
}
