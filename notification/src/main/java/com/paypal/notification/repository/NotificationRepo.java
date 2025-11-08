package com.paypal.notification.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paypal.notification.entity.Notification;

public interface NotificationRepo extends JpaRepository<Notification, Long> {
    List<Notification> findByUserId(Long userId);
}