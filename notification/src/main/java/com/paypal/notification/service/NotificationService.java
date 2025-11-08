package com.paypal.notification.service;

import java.util.List;

import com.paypal.notification.entity.Notification;

public interface NotificationService {
    Notification sendNotification(Notification notification);
    List<Notification> getNotificationByUserId(Long userId);
}