package com.project.chatserver.data;

import com.project.chatserver.domain.Channel;
import com.project.chatserver.domain.type.AccessType;
import com.project.chatserver.domain.type.ChannelType;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChannelDto{
    private String name;
    private String reference;

    //private Channel channel;

    private AccessType accessType;
    private ChannelType channelType;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
