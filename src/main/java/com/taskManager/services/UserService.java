package com.taskManager.services;

import com.taskManager.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUserById(Long id);

}
