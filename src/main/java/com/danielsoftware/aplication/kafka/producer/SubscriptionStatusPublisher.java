package com.danielsoftware.aplication.kafka.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubscriptionStatusPublisher {
    @Value(value = "${kafka.subscription-topic}")
    private String subscriptionTopic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void publishSubscriptionStatus(String subscriptionId, String subscriptionStatus) {
        kafkaTemplate.send(subscriptionTopic, subscriptionId, subscriptionStatus);
    }
}
