package com.project.chatserver.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.*;

@Component
@RequiredArgsConstructor
public class WebSocketEventListener {
    private final SimpUserRegistry simpUserRegistry;
    private final SimpMessagingTemplate simpMessagingTemplate;
    @EventListener
    public void handleWebSocketConnectEvent(SessionConnectedEvent sessionConnectedEvent) {
        System.out.println("[CONNECT] - " + sessionConnectedEvent.getUser());
    }
    @EventListener
    public void handleWebSocketDisconnectEvent(SessionDisconnectEvent sessionDisconnectEvent) {
        System.out.println("[DISCONNECT] - " + sessionDisconnectEvent.getCloseStatus());
    }

    @EventListener
    public void handleWebSocketMessageEvent(AbstractSubProtocolEvent event) {
        if (event instanceof SessionSubscribeEvent) {
            handleSubscribeEvent((SessionSubscribeEvent) event);
        } else if (event instanceof SessionUnsubscribeEvent) {
            handleUnsubscribeEvent((SessionUnsubscribeEvent) event);
        }
        //System.out.println(event.getMessage());
    }

    private void handleSubscribeEvent(SessionSubscribeEvent event) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
        String destination = accessor.getDestination();

        System.out.println("User subscribed to: " + destination + " - " + accessor.getUser());
    }

    private void handleUnsubscribeEvent(SessionUnsubscribeEvent event) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
        String destination = accessor.getDestination();

        // Unsubscribe 이벤트 처리
        System.out.println("User unsubscribed from: " + destination + " - " + accessor.getUser());
    }
}
