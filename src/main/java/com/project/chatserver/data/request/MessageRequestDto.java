package com.project.chatserver.data.request;

import com.project.chatserver.domain.type.MessageType;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequestDto {
    private String content;
    private MessageType messageType;
    private LocalDateTime createdTime;

    // Member
    private Long memberId;

    // Channel
    private Long channelId;
    private String reference;
}
