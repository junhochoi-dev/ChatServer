package com.project.chatserver.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class ChatChannelDto {
    private String id;
    private String name;

    private Set<WebSocketSession> sessions = new HashSet<>();

    public static ChatChannelDto create(String name){
        ChatChannelDto chatChannelDto = new ChatChannelDto();

        chatChannelDto.id = UUID.randomUUID().toString();
        chatChannelDto.name = name;

        return chatChannelDto;
    }
}
