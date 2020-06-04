package com.taskManager.repository;

import com.taskManager.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {

    List<Notification> findByUserId(Long id);

//    @Query("select notification from notification n where n.user.id = ?1 and n.isRead = ?2")
    @Query("from notification n where n.user.id = ?1 and n.isRead = ?2")
    List<Notification> findByUserAndIsRead(Long userId, boolean isRead);
}
