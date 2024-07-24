package com.SpringbootProject.ProjectManagementTool.Services;

import com.SpringbootProject.ProjectManagementTool.model.Enum.PlanType;
import com.SpringbootProject.ProjectManagementTool.model.Subscription;
import com.SpringbootProject.ProjectManagementTool.model.User;

public interface SubscriptionService {
    Subscription createSubscription(User user );
    Subscription getUserSubscription(Long userId);

    Subscription upgradeSubscription(Long userId, PlanType planType);
    boolean isValid(Subscription subscription);
}
