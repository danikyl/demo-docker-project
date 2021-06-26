package com.danielsoftware.aplication.service.implementation;

import com.danielsoftware.aplication.MainApplication;
import com.danielsoftware.aplication.domain.dto.SubscriptionNotificationRequest;
import com.danielsoftware.aplication.rabbitmq.Receiver;
import com.danielsoftware.aplication.service.SubscriptionService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    SubscriptionServiceImpl(RabbitTemplate rabbitTemplate, Receiver receiver) {
        this.rabbitTemplate = rabbitTemplate;
        this.receiver = receiver;
    }

    @Override
    public void publishSubscriptionNotification(SubscriptionNotificationRequest subscriptionNotificationRequest) {
        rabbitTemplate.convertAndSend("spring-boot-exchange", "foo.bar.baz", "Hello from RabbitMQ!");
    }
}
