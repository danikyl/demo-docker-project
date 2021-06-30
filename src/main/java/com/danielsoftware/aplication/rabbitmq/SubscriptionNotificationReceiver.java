package com.danielsoftware.aplication.rabbitmq;

import com.danielsoftware.aplication.domain.dto.SubscriptionNotificationRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionNotificationReceiver {

    public void receiveMessage(SubscriptionNotificationRequest notificationRequest) {
        System.out.println("Received <" + notificationRequest + ">");
    }

}
