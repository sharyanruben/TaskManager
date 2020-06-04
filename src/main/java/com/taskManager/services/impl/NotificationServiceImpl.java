package com.taskManager.services.impl;

import com.taskManager.model.Notification;
import com.taskManager.repository.NotificationRepository;
import com.taskManager.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    private NotificationRepository notificationRepository;

    public NotificationServiceImpl(@Autowired NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public List<Notification> getNotificationsByUserIdWhichIsUnRead(Long userId) {
        return notificationRepository.findByUserAndIsRead(userId,false);
    }

    @Override
    public List<Notification> getNotificationsByUserId(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    @Override
    public void saveNotification(Notification notification) {
        notificationRepository.save(notification);
    }
}
