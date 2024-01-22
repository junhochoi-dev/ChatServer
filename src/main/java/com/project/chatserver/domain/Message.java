package com.project.chatserver.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.project.chatserver.domain.type.MessageType;

@Entity
public class Message{
    @Id
    private String id;
    private String sender;
    private String content;

    private String reference;

    private MessageType messageType;

    private String createdTime;
}
