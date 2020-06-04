package com.taskManager.services.impl;

import com.taskManager.model.Task;
import com.taskManager.model.User;
import com.taskManager.repository.TaskRepository;
import com.taskManager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    public TaskServiceImpl(@Autowired TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("task by id not found id=%d",id)));
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getTasksByUserId(Long userId) {
        return taskRepository.findByUserId(userId);
    }
}
