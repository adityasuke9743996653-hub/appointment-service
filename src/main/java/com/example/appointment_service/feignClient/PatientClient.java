package com.example.appointment_service.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.appointment_service.DTO.PatientDTO;


@FeignClient(name = "PATIENT-SERVICE", url = "http://localhost:8081")
public interface PatientClient {
    @GetMapping("/patients")
    List<PatientDTO> getAllPatients();

    @PostMapping("/patients")
    PatientDTO addPatient(@RequestBody PatientDTO patient);

    // Update patient by ID
    @PutMapping("/patients/{id}")
    PatientDTO updatePatient(@PathVariable Long id, @RequestBody PatientDTO patient);

    // Delete patient by ID
    @DeleteMapping("/patients/{id}")
    void deletePatient(@PathVariable Long id);

    // Optional: Get patient by ID
    @GetMapping("/patients/{id}")
    PatientDTO getPatientById(@PathVariable Long id);
}


