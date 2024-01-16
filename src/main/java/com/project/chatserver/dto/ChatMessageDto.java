package com.project.chatserver.dto;

import com.project.chatserver.MessageType;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ChatMessageDto {
    private String id;
    private String channel;
    private String content;

    private String sender;

    private MessageType type;
    
    // 전송시간
}
