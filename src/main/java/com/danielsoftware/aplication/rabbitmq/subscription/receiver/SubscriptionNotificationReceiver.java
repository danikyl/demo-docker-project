package com.danielsoftware.aplication.rabbitmq.subscription.receiver;

import com.danielsoftware.aplication.domain.dto.SubscriptionNotificationRequest;
import com.danielsoftware.aplication.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubscriptionNotificationReceiver {
    private final SubscriptionService subscriptionService;

    public void receiveMessage(SubscriptionNotificationRequest notificationRequest) {
        subscriptionService.processSubscriptionNotification(notificationRequest);
    }

}
