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

//    @ManyToOne
//    @JoinColumn(name = "channel_id")
//    private Channel channel;

//    private Long channelId;

    private Long memberId;
    private String nickname;
    private String reference;

    private MessageType messageType;

    private LocalDateTime createdTime;

    @Builder

    public Message(String content, Long memberId, String nickname, String reference, MessageType messageType, LocalDateTime createdTime) {
        this.content = content;
        this.memberId = memberId;
        this.nickname = nickname;
        this.reference = reference;
        this.messageType = messageType;
        this.createdTime = createdTime;
    }
}
