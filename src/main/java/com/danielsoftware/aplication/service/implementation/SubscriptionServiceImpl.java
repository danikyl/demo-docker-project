package com.danielsoftware.aplication.service.implementation;

import com.danielsoftware.aplication.domain.dto.SubscriptionNotificationRequest;
import com.danielsoftware.aplication.rabbitmq.SubscriptionNotificationReceiver;
import com.danielsoftware.aplication.service.SubscriptionService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private final RabbitTemplate rabbitTemplate;
    private final SubscriptionNotificationReceiver subscriptionNotificationReceiver;

    SubscriptionServiceImpl(RabbitTemplate rabbitTemplate, SubscriptionNotificationReceiver subscriptionNotificationReceiver) {
        this.rabbitTemplate = rabbitTemplate;
        this.subscriptionNotificationReceiver = subscriptionNotificationReceiver;
    }

    @Override
    public void publishSubscriptionNotification(SubscriptionNotificationRequest subscriptionNotificationRequest) {

        rabbitTemplate.convertAndSend("spring-boot-exchange", "foo.bar.baz", subscriptionNotificationRequest);
    }
}
