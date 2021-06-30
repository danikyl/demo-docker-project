package com.danielsoftware.aplication.service;

import com.danielsoftware.aplication.domain.dto.SubscriptionNotificationRequest;

public interface SubscriptionService {
    void publishSubscriptionNotification(SubscriptionNotificationRequest subscriptionNotificationRequest);

    public void processSubscriptionNotification(SubscriptionNotificationRequest notificationRequest);
}
