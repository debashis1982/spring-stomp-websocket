package com.service;

import org.springframework.messaging.Message;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public DataService(
            SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @Async
    public void getData(final Message message){
        final SimpMessageHeaderAccessor simpMessageHeaderAccessor = SimpMessageHeaderAccessor
                .getAccessor(message, SimpMessageHeaderAccessor.class);
        System.out.println("sending data to "+simpMessageHeaderAccessor.getDestination());
        simpMessagingTemplate.convertAndSend(simpMessageHeaderAccessor.getDestination(), "place holder");
    }
}
