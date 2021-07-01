package com.danielsoftware.aplication.service.implementation;

import com.danielsoftware.aplication.domain.model.EventHistory;
import com.danielsoftware.aplication.repository.EventHistoryRepository;
import com.danielsoftware.aplication.service.EventHistoryService;
import org.springframework.stereotype.Service;

@Service
public class EventHistoryServiceImpl implements EventHistoryService {
    private final EventHistoryRepository eventHistoryRepository;

    EventHistoryServiceImpl(EventHistoryRepository eventHistoryRepository) {
        this.eventHistoryRepository = eventHistoryRepository;
    }

    @Override
    public Iterable<EventHistory> findAll() {
        Iterable<EventHistory> all = eventHistoryRepository.findAll();
        return all;
    }
}
