package com.project.chatserver.data;

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
