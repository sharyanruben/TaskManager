package com.taskManager.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String body;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public Comment() {
    }

    public Comment(Long id, String body, Task task) {
        this.id = id;
        this.body = body;
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) &&
                Objects.equals(body, comment.body) &&
                Objects.equals(task, comment.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, body, task);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", task=" + task +
                '}';
    }
}
