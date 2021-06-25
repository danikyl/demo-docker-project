package com.danielsoftware.aplication.controller;

import com.danielsoftware.aplication.domain.dto.SubscriptionNotificationRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/subscription")
public class SubscriptionController {

    @PostMapping(path = "/update")
    public void updateSubscription(SubscriptionNotificationRequest subscriptionNotificationRequest) {
        System.out.println(subscriptionNotificationRequest.toString());
    }
}
