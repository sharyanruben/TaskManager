package com.taskManager.controller;

import com.taskManager.model.Comment;
import com.taskManager.model.Notification;
import com.taskManager.model.Task;
import com.taskManager.model.User;
import com.taskManager.model.enums.Status;
import com.taskManager.services.CommentService;
import com.taskManager.services.NotificationService;
import com.taskManager.services.TaskService;
import com.taskManager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/assign", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AssignController {

    private TaskService taskService;

    private UserService userService;

    private CommentService commentService;

    private NotificationService notificationService;

    @Autowired
    public AssignController(TaskService taskService,
                            UserService userService,
                            CommentService commentService,
                            NotificationService notificationService) {
        this.taskService = taskService;
        this.userService = userService;
        this.commentService = commentService;
        this.notificationService = notificationService;
    }

    @PostMapping("edit")
    public ModelAndView editTask(@RequestParam("taskId") Long taskId, @RequestParam("userId") String userId, @RequestParam("status") String status, @RequestParam("comment") String bodyOfComment, @RequestParam("userIdOfOldTask") Long userIdOfOldTask, Model model) {
        Task task = taskService.getTaskById(taskId);
        boolean isChange = checkingStatus(task, status);

        Long id = Long.parseLong(userId);
        User user = userService.getUserById(id);

        if (!task.getUser().getId().equals(user.getId())) {
            task.setUser(user);
            isChange = true;
        }

        if (!bodyOfComment.equals("")) {
            addComment(taskId,bodyOfComment,task);
            isChange = true;
        }
        if (isChange) {
            taskService.save(task);
            Notification notification = new Notification();
            notification.setRead(false);
            notification.setUser(user);
            notificationService.saveNotification(notification);
            model.addAttribute("message", "Task successfully editing");
        } else {
            model.addAttribute("message", "Task is not changed");
        }

        return new ModelAndView("forward:/task/edit/" + taskId, "userIdOfOldTask", userIdOfOldTask);
    }

    private void addComment(Long taskId,String bodyOfComment,Task task){
        List<Comment> comments = commentService.getCommentsByTaskId(taskId);
        Comment comment = new Comment();
        comment.setBody(bodyOfComment);
        comment.setTask(task);
        comments.add(comment);
        task.setComments(comments);
        commentService.addComment(comment);
    }

    private boolean checkingStatus(Task task, String status) {
        if (!task.getStatus().name().equals(status)) {
            task.setStatus(Status.valueOf(status));
            return true;
        }
        return false;
    }
}
