package com.taskManager.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String userName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Task> tasks;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Notification> notifications;

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public User() {
    }

    public User(Long id, String userName, List<Task> tasks, List<Notification> notifications) {
        this.id = id;
        this.userName = userName;
        this.tasks = tasks;
        this.notifications = notifications;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", tasks=" + tasks +
                ", notifications=" + notifications +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(tasks, user.tasks) &&
                Objects.equals(notifications, user.notifications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, tasks, notifications);
    }
}