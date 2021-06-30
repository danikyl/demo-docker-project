package com.danielsoftware.aplication.controller;

import com.danielsoftware.aplication.domain.dto.SubscriptionNotificationRequest;
import com.danielsoftware.aplication.service.SubscriptionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/subscription")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping(path = "/update")
    public void updateSubscription(@RequestBody SubscriptionNotificationRequest subscriptionNotificationRequest) {
        subscriptionService.publishSubscriptionNotification(subscriptionNotificationRequest);
    }
}
