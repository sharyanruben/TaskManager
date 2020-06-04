package com.taskManager.services;

import com.taskManager.model.Comment;

import java.util.List;

public interface CommentService {

    void addComment(Comment comment);

    List<Comment> getComments();

    Comment getCommentById(Long id);

    List<Comment> getCommentsByTaskId(Long taskId);

}
