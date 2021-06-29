package com.danielsoftware.aplication.repository;

import com.danielsoftware.aplication.domain.model.EventHistory;
import org.springframework.data.repository.CrudRepository;

public interface EventHistoryRepository extends CrudRepository<EventHistory, Integer> {
}
