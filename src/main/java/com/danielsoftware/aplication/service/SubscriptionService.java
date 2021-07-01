package com.danielsoftware.aplication.service;

import com.danielsoftware.aplication.domain.dto.SubscriptionNotificationRequest;
import com.danielsoftware.aplication.domain.model.Subscription;

public interface SubscriptionService {
    void publishSubscriptionNotification(SubscriptionNotificationRequest subscriptionNotificationRequest);

    void processSubscriptionNotification(SubscriptionNotificationRequest notificationRequest);

    Iterable<Subscription> findAll();


}
