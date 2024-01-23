package com.project.chatserver.domain;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.project.chatserver.domain.type.MessageType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Message{
    @Id
    private String id;
    private String sender;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_id")
    private Channel channel;

    private MessageType messageType;

    private String createdTime;
}
