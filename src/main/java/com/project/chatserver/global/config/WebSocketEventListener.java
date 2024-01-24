package com.project.chatserver.global.config;

import com.project.chatserver.domain.Channel;
import com.project.chatserver.service.ChannelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.messaging.*;

import java.util.HashSet;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener {
    private final SimpUserRegistry simpUserRegistry;
    private final SimpMessagingTemplate simpMessagingTemplate;

    private ChannelService channelService;

    @EventListener
    public void handleWebSocketConnectionEvent(SessionConnectEvent sessionConnectEvent){
        String sessionId = sessionConnectEvent.getMessage().getHeaders().get("simpSessionId").toString();
        log.info("[CONNECTION] ({})", sessionId);
    }

    @EventListener
    public void handlerWebSocketDisconnectionEvent(SessionDisconnectEvent sessionDisconnectEvent){
        String sessionId = sessionDisconnectEvent.getSessionId();
        log.info("[DISCONNECT] ({})", sessionId);
    }

    @EventListener
    private void handleSubscribeEvent(SessionSubscribeEvent event) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
        log.info("[Subscribe] {}", accessor.getDestination());
    }

    @EventListener
    private void handleUnsubscribeEvent(SessionUnsubscribeEvent event) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
        String destination = accessor.getDestination();
        log.info("[Unsubscribe] {}", accessor.getDestination());
    }
}
