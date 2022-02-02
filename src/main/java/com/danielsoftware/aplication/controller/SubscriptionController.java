package com.danielsoftware.aplication.controller;

import com.danielsoftware.aplication.domain.dto.SubscriptionNotificationRequest;
import com.danielsoftware.aplication.domain.model.Subscription;
import com.danielsoftware.aplication.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/subscription")
@RequiredArgsConstructor
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @PostMapping(path = "/update")
    public void updateSubscription(@RequestBody SubscriptionNotificationRequest subscriptionNotificationRequest) {
        subscriptionService.publishSubscriptionNotification(subscriptionNotificationRequest);
    }

    @GetMapping(path = "/all")
    public Iterable<Subscription> findAll() {
        return subscriptionService.findAll();
    }

    @GetMapping(path = "/status/{id}")
    public String findAll(@PathVariable  String id) {
        return subscriptionService.getSubscriptionStatus(id);
    }
}
