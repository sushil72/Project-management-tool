package com.SpringbootProject.ProjectManagementTool.repository;

import com.SpringbootProject.ProjectManagementTool.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Subscription findByUserId(Long userId);
}
