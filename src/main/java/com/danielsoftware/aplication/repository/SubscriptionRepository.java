package com.danielsoftware.aplication.repository;

import com.danielsoftware.aplication.domain.model.Subscription;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {
}
