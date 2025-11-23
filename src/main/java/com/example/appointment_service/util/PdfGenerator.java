package com.example.appointment_service.util;

import com.example.appointment_service.entity.Appointment;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class PdfGenerator {

    public static ByteArrayInputStream generateAppointmentPdf(Appointment appointment) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            document.add(new Paragraph("Appointment Details"));
            document.add(new Paragraph("Patient: " + appointment.getPatientName()));
            document.add(new Paragraph("Doctor: " + appointment.getDoctorName()));
            document.add(new Paragraph("Date: " + appointment.getAppointmentDateTime().toString()));

            document.close();
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate PDF file: " + e.getMessage(), e);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}