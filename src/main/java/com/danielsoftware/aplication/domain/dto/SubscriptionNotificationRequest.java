package com.danielsoftware.aplication.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SubscriptionNotificationRequest {
    @JsonProperty("notification_type")
    private String notificationType;

    @JsonProperty("subscription")
    private String subscriptionId;
}
