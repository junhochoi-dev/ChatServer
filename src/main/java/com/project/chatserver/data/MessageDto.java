package com.project.chatserver.data;

import com.project.chatserver.MessageType;
import lombok.*;

@Builder
public record MessageDto(
    String senderName,
    String receiverName,
    String message,
    String date,
    MessageType type
) { }
