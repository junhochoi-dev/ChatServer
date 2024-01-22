package com.project.chatserver.data;

import com.project.chatserver.MessageType;
import lombok.*;

import java.time.LocalDateTime;

@Builder
public record MessageDto(
    String sender,
    String content,
    String reference,
    MessageType messageType,
    LocalDateTime createdTime
) { }
