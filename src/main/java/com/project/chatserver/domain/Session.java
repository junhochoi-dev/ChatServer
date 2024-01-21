package com.project.chatserver.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
public class Session {
    @Id
    @GeneratedValue
    private Long id;

    private String channel;

    @CreatedDate
    private LocalDateTime createdTime;
}
