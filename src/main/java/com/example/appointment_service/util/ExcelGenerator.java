package com.example.appointment_service.util;

import com.example.appointment_service.entity.Appointment;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ExcelGenerator {

    public static ByteArrayInputStream generateAppointmentExcel(Appointment appointment) {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Appointment");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Patient Name");
            header.createCell(1).setCellValue("Doctor Name");
            header.createCell(2).setCellValue("Date");

            Row data = sheet.createRow(1);
            data.createCell(0).setCellValue(appointment.getPatientName());
            data.createCell(1).setCellValue(appointment.getDoctorName());
            data.createCell(2).setCellValue(appointment.getAppointmentDateTime().toString());

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate Excel file: " + e.getMessage(), e);
        }
    }
}