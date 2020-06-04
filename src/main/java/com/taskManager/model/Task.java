package com.taskManager.model;

import com.taskManager.model.enums.Severity;
import com.taskManager.model.enums.Status;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static javax.persistence.TemporalType.TIMESTAMP;

@Entity(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    @CreatedDate
    @Temporal(TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @OneToMany(mappedBy = "task",cascade = CascadeType.ALL)
    private List<Comment> comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Task() {
    }

    public Task(Long id,String name, Status status, Severity severity, Date createdDate, List<Comment> comments, User user) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.severity = severity;
        this.createdDate = createdDate;
        this.comments = comments;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name=" + name +
                ", status=" + status +
                ", severity=" + severity +
                ", createdDate=" + createdDate +
                ", comments=" + comments +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) &&
                status == task.status &&
                severity == task.severity &&
                Objects.equals(name, task.name) &&
                Objects.equals(createdDate, task.createdDate) &&
                Objects.equals(comments, task.comments) &&
                Objects.equals(user, task.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, severity, createdDate, comments, user);
    }
}
