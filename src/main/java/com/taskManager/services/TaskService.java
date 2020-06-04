package com.taskManager.services;

import com.taskManager.model.Task;

import java.util.List;

public interface TaskService {

    void save(Task task);

    Task getTaskById(Long id);

    List<Task> getTasks();

    List<Task> getTasksByUserId(Long userId);

}
