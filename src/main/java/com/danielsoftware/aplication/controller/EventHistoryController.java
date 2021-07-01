package com.danielsoftware.aplication.controller;

import com.danielsoftware.aplication.domain.model.EventHistory;
import com.danielsoftware.aplication.service.EventHistoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/eventHistory")
public class EventHistoryController {
    private final EventHistoryService eventHistoryService;

    EventHistoryController(EventHistoryService eventHistoryService) {
        this.eventHistoryService = eventHistoryService;
    }

    @GetMapping(path = "/all")
    public Iterable<EventHistory> findAll() {
        return eventHistoryService.findAll();
    }
}
