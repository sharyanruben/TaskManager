package com.taskManager.controller;

import com.taskManager.model.Task;
import com.taskManager.model.User;
import com.taskManager.model.enums.Status;
import com.taskManager.services.TaskService;
import com.taskManager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/task", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TaskController {

    private TaskService taskService;

    private UserService userService;

    @Autowired
    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @PostMapping("createTask")
    public ModelAndView createTask(@ModelAttribute(value = "task") Task task, @RequestParam("userId") String userId){
        Long id = Long.parseLong(userId);
        task.setStatus(Status.STARTED);
        task.setUser(userService.getUserById(id));
        task.setCreatedDate(new Date());

        taskService.save(task);

        return new ModelAndView("forward:/user/info"+"/"+id);
    }

    @RequestMapping("/edit/{taskId}")
    public ModelAndView edit(@PathVariable("taskId") Long taskId,Model model){
        Task task = taskService.getTaskById(taskId);
        List<User> users = userService.getUsers();
        model.addAttribute("user",task.getUser());
        model.addAttribute("users",users);
        return new ModelAndView("editTask","task",task);
    }
}
