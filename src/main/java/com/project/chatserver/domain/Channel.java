package com.project.chatserver.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Channel{
    @Id
    private String id;
    private String name;
    private String reference;
    private ChannelType type;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
