package com.danielsoftware.aplication.integration;

import com.danielsoftware.aplication.domain.dto.SubscriptionNotificationRequest;
import com.danielsoftware.aplication.domain.model.Subscription;
import com.danielsoftware.aplication.rabbitmq.subscription.producer.SubscriptionNotificationProducer;
import com.danielsoftware.aplication.repository.EventHistoryRepository;
import com.danielsoftware.aplication.repository.StatusRepository;
import com.danielsoftware.aplication.repository.SubscriptionRepository;
import com.danielsoftware.aplication.service.SubscriptionService;
import com.danielsoftware.aplication.service.implementation.SubscriptionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@RequiredArgsConstructor
public class SendSubscriptionNotificationAndVerifyPersistedData {

    private final SubscriptionRepository subscriptionRepository;

    private final StatusRepository statusRepository;

    private final EventHistoryRepository eventHistoryRepository;


    @Test
    public void sendSubscriptionsAndVerifyResult() {
        boolean isValid = true;
        SubscriptionNotificationProducer subscriptionNotificationProducer = new SubscriptionNotificationProducer(new RabbitTemplate());
        SubscriptionService subscriptionService = new SubscriptionServiceImpl(subscriptionRepository, statusRepository, eventHistoryRepository, subscriptionNotificationProducer);

        SubscriptionNotificationRequest subscriptionNotificationRequest = SubscriptionNotificationRequest.builder().subscriptionId("testkey123").notificationType("SUBSCRIPTION_PURCHASED").build();
        subscriptionService.processSubscriptionNotification(subscriptionNotificationRequest);
        Subscription subscription = subscriptionRepository.findById("testkey123");
        if (!subscription.getStatus().getName().equals("active")) isValid = false;

        subscriptionNotificationRequest.setNotificationType("SUBSCRIPTION_CANCELED");
        subscriptionService.processSubscriptionNotification(subscriptionNotificationRequest);
        subscription = subscriptionRepository.findById("testkey123");
        if (!subscription.getStatus().getName().equals("canceled")) isValid = false;

        subscriptionNotificationRequest.setNotificationType("SUBSCRIPTION_RESTARTED");
        subscriptionService.processSubscriptionNotification(subscriptionNotificationRequest);
        subscription = subscriptionRepository.findById("testkey123");
        if (!subscription.getStatus().getName().equals("active")) isValid = false;


        assertEquals(isValid, true);

    }
}
