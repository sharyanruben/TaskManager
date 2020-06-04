package com.taskManager.controller;

import com.taskManager.model.Notification;
import com.taskManager.model.Task;
import com.taskManager.model.User;
import com.taskManager.services.NotificationService;
import com.taskManager.services.TaskService;
import com.taskManager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    private boolean isSelected = false;

    private UserService userService;

    private TaskService taskService;

    private NotificationService notificationService;

    @Autowired
    public UserController(UserService userService, TaskService taskService, NotificationService notificationService) {
        this.userService = userService;
        this.taskService = taskService;
        this.notificationService = notificationService;
    }

    @RequestMapping("start")
    public ModelAndView showUser(Model model){
        List<User> users = userService.getUsers();
        model.addAttribute("users",users);
        model.addAttribute("isSelected",isSelected);
        return new ModelAndView("user");
    }

    @RequestMapping("/info/{userId}")
    public ModelAndView getUserInformation(@PathVariable("userId")Long id, Model model){
        isSelected = true;
        List<Task> tasks= taskService.getTasksByUserId(id);
        List<Notification> notifications = notificationService.getNotificationsByUserIdWhichIsUnRead(id);
        if (!notifications.isEmpty()){
            model.addAttribute("notification","you have new notifications");
        }
        model.addAttribute("tasks",tasks);
        model.addAttribute("user",userService.getUserById(id));
        return new ModelAndView("forward:/user/start");
    }

}
