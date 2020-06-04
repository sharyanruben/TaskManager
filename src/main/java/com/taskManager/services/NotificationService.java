package com.taskManager.services;

import com.taskManager.model.Notification;

import java.util.List;

public interface NotificationService {

    List<Notification> getNotificationsByUserIdWhichIsUnRead(Long userId);

    List<Notification> getNotificationsByUserId(Long userId);

    void saveNotification(Notification notification);

}
