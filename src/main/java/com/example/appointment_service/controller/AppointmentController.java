package com.example.appointment_service.controller;

import com.example.appointment_service.entity.Appointment;
import com.example.appointment_service.service.AppointmentService;
import com.example.appointment_service.util.ExcelGenerator;
import com.example.appointment_service.util.PdfGenerator;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    // Create new appointment
    @PostMapping
    public ResponseEntity<Appointment> create(@RequestBody Appointment appointment) {
        return ResponseEntity.ok(service.create(appointment));
    }

    // Get all appointments
    @GetMapping
    public ResponseEntity<List<Appointment>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // Get appointment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update appointment
    @PutMapping("/{id}")
    public ResponseEntity<Appointment> update(@PathVariable Long id, @RequestBody Appointment appointment) {
        return ResponseEntity.ok(service.update(id, appointment));
    }

    // Delete appointment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/{id}/excel")
    public ResponseEntity<InputStreamResource> downloadExcel(@PathVariable Long id) {
        Appointment appointment = service.getAppointmentById(id);
        ByteArrayInputStream bis = ExcelGenerator.generateAppointmentExcel(appointment);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=appointment_" + id + ".xlsx")
                .contentType(MediaType.parseMediaType(
                        "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(new InputStreamResource(bis));
    }




    @GetMapping(value = "/{id}/pdf", produces = "application/pdf")
    public ResponseEntity<byte[]> downloadPdf(@PathVariable Long id) {
        Appointment appointment = service.getById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        ByteArrayInputStream bis = PdfGenerator.generateAppointmentPdf(appointment);

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=appointment_" + id + ".pdf")
                .body(bis.readAllBytes());
    }


}
