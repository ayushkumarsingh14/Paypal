package com.paypal.notification.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.notification.entity.Notification;
import com.paypal.notification.repository.NotificationRepo;

@Service
public class NotificationServiceImp implements NotificationService {

    @Autowired
    private NotificationRepo notificationRepo;

    public Notification sendNotification(Notification notification){
        notification.setSendAt(LocalDateTime.now());
        return notificationRepo.save(notification);
    }

    public List<Notification> getNotificationByUserId(Long userId){
        return notificationRepo.findByUserId(userId);
    }

}