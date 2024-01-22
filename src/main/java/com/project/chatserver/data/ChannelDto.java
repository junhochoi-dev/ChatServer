package com.project.chatserver.data;

import com.project.chatserver.domain.type.AccessType;
import com.project.chatserver.domain.type.ChannelType;

import lombok.Builder;

@Builder
public record ChannelDto (
    String id,
    String name,
    String reference,
    AccessType accessType,
    ChannelType channelType
) { }
