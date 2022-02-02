package com.danielsoftware.aplication.kafka.stream;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionStatusProcessor {
    private static final Serde<String> STRING_SERDE = Serdes.String();

    @Autowired
    void buildPipeline(StreamsBuilder streamsBuilder) {
        KTable<String, String> updatedStatus = streamsBuilder
                .table("subscription-status", Consumed.with(STRING_SERDE, STRING_SERDE),
                        Materialized.as("subscription-status-store"));

        updatedStatus.toStream().to("updated-status");
    }
}
