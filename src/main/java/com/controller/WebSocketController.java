package com.controller;

import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;
import com.service.DataService;

@RestController

public class WebSocketController {

    private  final DataService dataService;

    public WebSocketController(DataService dataService) {
        this.dataService = dataService;
    }

    @EventListener
    public void handleSessionSubscribeEvent(final SessionSubscribeEvent event) {
        dataService.getData(event.getMessage());
        System.out.println("subscribe complete");
    }
}
