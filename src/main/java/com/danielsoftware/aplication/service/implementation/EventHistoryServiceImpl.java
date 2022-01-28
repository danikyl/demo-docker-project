package com.danielsoftware.aplication.service.implementation;

import com.danielsoftware.aplication.domain.model.EventHistory;
import com.danielsoftware.aplication.repository.EventHistoryRepository;
import com.danielsoftware.aplication.service.EventHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventHistoryServiceImpl implements EventHistoryService {
    private final EventHistoryRepository eventHistoryRepository;

    public Iterable<EventHistory> findAll() {
        Iterable<EventHistory> all = eventHistoryRepository.findAll();
        return all;
    }
}
