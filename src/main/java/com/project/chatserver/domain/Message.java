package com.project.chatserver.domain;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.project.chatserver.domain.type.MessageType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue
    private Long id;
    private String content;
    private MessageType messageType;
    private LocalDateTime createdTime;

    // Member
    private Long memberId;

    // Channel
    private Long channelId;
    private String reference;

    @Builder
    public Message(String content, MessageType messageType, LocalDateTime createdTime, Long memberId, Long channelId, String reference) {
        this.content = content;
        this.messageType = messageType;
        this.createdTime = createdTime;
        this.memberId = memberId;
        this.channelId = channelId;
        this.reference = reference;
    }
}
