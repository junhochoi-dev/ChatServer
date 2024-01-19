package com.project.chatserver.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener {
    private final SimpUserRegistry simpUserRegistry;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @EventListener
    public void handleWebSocketConnectionEvent(SessionConnectEvent sessionConnectEvent){
        log.info("CONNECT");
    }
    @EventListener
    public void handlerWebSocketDisconnectionEvent(SessionDisconnectEvent sessionDisconnectEvent){
        log.info("DISCONNECT: SOCKETID[{}]","test");
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
