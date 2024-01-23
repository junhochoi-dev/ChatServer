package com.project.chatserver.data;

import com.project.chatserver.domain.type.AccessType;
import com.project.chatserver.domain.type.ChannelType;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChannelDto{
    private String id;

    private String name;
    private String reference;

    private AccessType accessType;
    private ChannelType channelType;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
