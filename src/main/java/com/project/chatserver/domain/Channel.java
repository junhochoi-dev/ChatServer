package com.project.chatserver.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

import com.project.chatserver.domain.type.AccessType;
import com.project.chatserver.domain.type.ChannelType;

@Entity
public class Channel{
    @Id
    private String id;
    private String name;
    private String reference;

    private AccessType accessType;
    private ChannelType channelType;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
