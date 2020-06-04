package com.taskManager.controller;

import com.taskManager.model.Notification;
import com.taskManager.model.Task;
import com.taskManager.services.NotificationService;
import com.taskManager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/notification", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class NotificationController {

    private NotificationService notificationService;

    private TaskService taskService;

    @Autowired
    public NotificationController(NotificationService notificationService, TaskService taskService) {
        this.notificationService = notificationService;
        this.taskService = taskService;
    }

    @GetMapping("/show/{userId}")
    public ModelAndView showNotification(@PathVariable(value = "userId") Long userId, Model model){
        List<Notification> notifications = notificationService.getNotificationsByUserIdWhichIsUnRead(userId);
        List<Task> tasks = taskService.getTasksByUserId(userId);
        notifications.forEach(not -> {
           not.setRead(true);
           notificationService.saveNotification(not);
        });
        model.addAttribute("tasks",tasks);
        model.addAttribute("userId",userId);
        return new ModelAndView("notification","countOfNotification",notifications.size());
    }
}
