package com.project.chatserver.data;

import com.project.chatserver.domain.ChannelType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Builder
public record ChannelDto (
    String id,
    String name,
    String reference,
    ChannelType type
) { }
