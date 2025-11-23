//package com.example.appointment_service.service;
//
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AppointmentProducer {
//
//    private final KafkaTemplate<String, String> kafkaTemplate;
//
//    public AppointmentProducer(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    public void sendAppointmentNotification(String message) {
//        kafkaTemplate.send("appointment-topic", message);
//        System.out.println("Sent message to Kafka: " + message);
//    }
//}

