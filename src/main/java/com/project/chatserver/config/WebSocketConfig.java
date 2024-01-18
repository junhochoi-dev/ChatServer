package com.project.chatserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // "ws://localhost:8080/websocketserver" WebSocket 연결 주소
        registry.addEndpoint("/websocketserver").setAllowedOrigins("*");
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // /queue 앞에 prefix가 붙은 주소로 메세지 수령 (개인채팅)
        // /subscription 앞에 prefix가 붙은 주소로 메세지 수령 (단체채팅)
        registry.enableSimpleBroker("/subscription");


        // Broker로 보내주세요!!!!!!!!!!
        // /publish 앞에 prefix가 붙은 주소로 메세지 전송
        registry.setApplicationDestinationPrefixes("/publish");
    }
}
