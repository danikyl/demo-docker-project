package com.danielsoftware.aplication.controller;

import com.danielsoftware.aplication.domain.model.EventHistory;
import com.danielsoftware.aplication.service.EventHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/eventHistory")
@RequiredArgsConstructor
public class EventHistoryController {
    private final EventHistoryService eventHistoryService;

    @GetMapping(path = "/all")
    public Iterable<EventHistory> findAll() {
        return eventHistoryService.findAll();
    }
}
