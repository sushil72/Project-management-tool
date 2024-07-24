package com.SpringbootProject.ProjectManagementTool.controller;

import com.SpringbootProject.ProjectManagementTool.Services.SubscriptionImpl;
import com.SpringbootProject.ProjectManagementTool.Services.SubscriptionService;
import com.SpringbootProject.ProjectManagementTool.Services.UserService;
import com.SpringbootProject.ProjectManagementTool.model.Enum.PlanType;
import com.SpringbootProject.ProjectManagementTool.model.Subscription;
import com.SpringbootProject.ProjectManagementTool.model.User;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public ResponseEntity<Subscription> getUserSubscription(
            @RequestHeader("Authorization") String jwt
    ) throws Exception{
        User user = userService.findUserProfileByJwt(jwt);
        Subscription subscription = subscriptionService.getUserSubscription(user.getId());
        return new ResponseEntity<>(subscription, HttpStatus.OK);
    }

    @PatchMapping("/upgrade")
    public ResponseEntity<Subscription> upgradeSubscription(
            @RequestHeader("Authorization") String jwt ,
            @RequestParam PlanType planType
            ) throws Exception{
        User user =  userService.findUserProfileByJwt(jwt);
        Subscription subscription = subscriptionService.upgradeSubscription(user.getId(),planType);
        return new ResponseEntity<>(subscription,HttpStatus.OK);
    }


}
