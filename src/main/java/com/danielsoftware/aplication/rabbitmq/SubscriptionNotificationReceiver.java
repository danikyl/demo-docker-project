package com.danielsoftware.aplication.rabbitmq;

import com.danielsoftware.aplication.domain.dto.SubscriptionNotificationRequest;
import com.danielsoftware.aplication.service.SubscriptionService;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionNotificationReceiver {
    private final SubscriptionService subscriptionService;

    SubscriptionNotificationReceiver(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    public void receiveMessage(SubscriptionNotificationRequest notificationRequest) {
        subscriptionService.processSubscriptionNotification(notificationRequest);
    }

}
