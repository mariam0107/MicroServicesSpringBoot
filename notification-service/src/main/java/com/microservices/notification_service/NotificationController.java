package com.microservices.notification_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    @GetMapping(value = "/{notificationId}")
    public Notifications getNotifications(@PathVariable("notificationId") String notificationId){
        Notifications notification1 = new Notifications(notificationId,"NotificationsDetail " + notificationId);
        return notification1;
    }

}
