package com.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@EnableAsync
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketMessageBrokerConfiguration implements WebSocketMessageBrokerConfigurer {

    public static final String REGISTRY_ENDPOINT = "/my-websocket";
    public static final String BROKER_TOPIC = "/my-websocket-broker";


    /**
     * Configure message broker.Default or simple message broker is used here.
     *
     * @param config MessageBrokerRegistry object
     */
    @Override
    public void configureMessageBroker(final MessageBrokerRegistry config) {
        config.enableSimpleBroker(BROKER_TOPIC);
        config.setPreservePublishOrder(true);
    }

    /**
     * Register STOMP endpoints.
     *
     * @param registry StompEndpointRegistry object
     */
    @Override
    public void registerStompEndpoints(final StompEndpointRegistry registry) {
        registry.addEndpoint(REGISTRY_ENDPOINT)
                .setAllowedOriginPatterns("*");
    }
}
