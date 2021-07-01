package com.danielsoftware.aplication.service;

import com.danielsoftware.aplication.domain.model.EventHistory;

public interface EventHistoryService {
    Iterable<EventHistory> findAll();
}
