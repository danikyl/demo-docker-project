package com.danielsoftware.aplication.service.implementation;

import com.danielsoftware.aplication.domain.dto.SubscriptionNotificationRequest;
import com.danielsoftware.aplication.domain.model.EventHistory;
import com.danielsoftware.aplication.domain.model.Status;
import com.danielsoftware.aplication.domain.model.Subscription;
import com.danielsoftware.aplication.rabbitmq.subscription.producer.SubscriptionNotificationProducer;
import com.danielsoftware.aplication.repository.EventHistoryRepository;
import com.danielsoftware.aplication.repository.StatusRepository;
import com.danielsoftware.aplication.repository.SubscriptionRepository;
import com.danielsoftware.aplication.service.SubscriptionService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private final RabbitTemplate rabbitTemplate;
    private final SubscriptionRepository subscriptionRepository;
    private final StatusRepository statusRepository;
    private final EventHistoryRepository eventHistoryRepository;
    private final SubscriptionNotificationProducer subscriptionNotificationProducer;

    SubscriptionServiceImpl(RabbitTemplate rabbitTemplate, StatusRepository statusRepository, SubscriptionRepository subscriptionRepository, EventHistoryRepository eventHistoryRepository, SubscriptionNotificationProducer subscriptionNotificationProducer) {
        this.rabbitTemplate = rabbitTemplate;
        this.subscriptionRepository = subscriptionRepository;
        this.statusRepository = statusRepository;
        this.eventHistoryRepository = eventHistoryRepository;
        this.subscriptionNotificationProducer = subscriptionNotificationProducer;
    }

    @Override
    public void publishSubscriptionNotification(SubscriptionNotificationRequest subscriptionNotificationRequest) {

        subscriptionNotificationProducer.publishNotification(subscriptionNotificationRequest);
    }


    @Override
    public void processSubscriptionNotification(SubscriptionNotificationRequest notificationRequest) {
        String statusName = notificationRequest.getNotificationType().equals("SUBSCRIPTION_CANCELED") ? "canceled" : "active";
        Status existingStatus = this.statusRepository.findByName(statusName);
        if (existingStatus == null) {
            existingStatus = Status.builder().name(statusName).createdAt(LocalDateTime.now()).build();
            existingStatus = statusRepository.save(existingStatus);
        }
        Subscription existingSubscription = subscriptionRepository.findById(notificationRequest.getSubscriptionId());
        if (existingSubscription == null) {
            existingSubscription = Subscription.builder().createdAt(LocalDateTime.now()).id(notificationRequest.getSubscriptionId()).build();
        }
        existingSubscription.setStatus(existingStatus);
        existingSubscription.setUpdatedAt(LocalDateTime.now());
        subscriptionRepository.save(existingSubscription);

        eventHistoryRepository.save(EventHistory.builder().createdAt(LocalDateTime.now()).changeType(notificationRequest.getNotificationType()).subscription(existingSubscription).build());

    }

    @Override
    public Iterable<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }
}
