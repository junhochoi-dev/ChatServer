package com.project.chatserver.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.project.chatserver.domain.type.AccessType;
import com.project.chatserver.domain.type.ChannelType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Getter
@NoArgsConstructor
public class Channel {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String reference;

    private AccessType accessType;
    private ChannelType channelType;

    @CreatedDate
    private LocalDateTime createdTime;
    @LastModifiedDate
    private LocalDateTime updatedTime;

    @Builder
    public Channel(String name, String reference, AccessType accessType, ChannelType channelType) {
        this.name = name;
        this.reference = reference;
        this.accessType = accessType;
        this.channelType = channelType;
    }
}
