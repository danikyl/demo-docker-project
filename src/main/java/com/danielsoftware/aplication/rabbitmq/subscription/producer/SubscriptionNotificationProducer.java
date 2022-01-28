package com.danielsoftware.aplication.rabbitmq.subscription.producer;

import com.danielsoftware.aplication.domain.dto.SubscriptionNotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubscriptionNotificationProducer {
    private final RabbitTemplate rabbitTemplate;

    public void publishNotification(SubscriptionNotificationRequest subscriptionNotificationRequest) {
        rabbitTemplate.convertAndSend("spring-boot-exchange", "foo.bar.baz", subscriptionNotificationRequest);
    }
}
