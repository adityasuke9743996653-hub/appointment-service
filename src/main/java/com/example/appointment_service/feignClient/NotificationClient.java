//package com.example.appointment_service.feignClient;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import com.example.appointment_service.DTO.NotificationDTO;
//
//@FeignClient(name = "notification-service")
//public interface NotificationClient {
//
//    @PostMapping("/notifications/send")
//    String sendNotification(@RequestBody NotificationDTO notificationDTO);
//}
