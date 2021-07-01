package com.danielsoftware.aplication.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SubscriptionNotificationRequest implements Serializable {
    @JsonProperty("notification_type")
    private String notificationType;

    @JsonProperty("subscription")
    private String subscriptionId;
}
