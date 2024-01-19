package com.project.chatserver.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
public class Message{
    @Id
    private String id;
    private String content;

    private LocalDateTime createdTime;
}
