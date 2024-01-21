package com.project.chatserver.config;

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

    private HashSet<String> sessionList = new HashSet<>();

    public void checkSessionList(){
        for(String session: sessionList){
            System.out.println(session);
        }
    }

    @EventListener
    public void handleWebSocketConnectionEvent(SessionConnectEvent sessionConnectEvent){
        String sessionId = sessionConnectEvent.getMessage().getHeaders().get("simpSessionId").toString();
        log.info("CONNECTION SOCKETID: [{}]", sessionId);
        sessionList.add(sessionId);
        checkSessionList();
    }

    @EventListener
    public void handlerWebSocketDisconnectionEvent(SessionDisconnectEvent sessionDisconnectEvent){
        String sessionId = sessionDisconnectEvent.getSessionId();
        log.info("DISCONNECT SOCKETID: [{}]", sessionId);
        sessionList.remove(sessionId);
        checkSessionList();
    }

    private void handleSubscribeEvent(SessionSubscribeEvent event) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
        String destination = accessor.getDestination();

        System.out.println("User subscribed to: " + destination + " - " + accessor.getUser());
    }

    private void handleUnsubscribeEvent(SessionUnsubscribeEvent event) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
        String destination = accessor.getDestination();

        System.out.println("User unsubscribed from: " + destination + " - " + accessor.getUser());
    }
}
