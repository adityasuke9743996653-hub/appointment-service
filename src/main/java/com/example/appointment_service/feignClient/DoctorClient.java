package com.example.appointment_service.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.appointment_service.DTO.DoctorDTO;

@FeignClient(name = "DOCTOR-SERVICE", url = "http://localhost:8082")
public interface DoctorClient {
	  	@GetMapping("/doctors")
	    List<DoctorDTO> getAllDoctors();

	    @PostMapping("/doctors")
	    DoctorDTO addDoctor(@RequestBody DoctorDTO doctor);

	    // Update doctor by ID
	    @PutMapping("/doctors/{id}")
	    DoctorDTO updateDoctor(@PathVariable Long id, @RequestBody DoctorDTO doctor);

	    // Delete doctor by ID
	    @DeleteMapping("/doctors/{id}")
	    void deleteDoctor(@PathVariable Long id);

	    // Optional: Get doctor by ID
	    @GetMapping("/doctors/{id}")
	    DoctorDTO getDoctorById(@PathVariable Long id);
}
