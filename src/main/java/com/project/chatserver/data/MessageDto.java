package com.project.chatserver.data;

import com.project.chatserver.domain.type.MessageType;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto{
    private String sender;
    private String content;
    private String reference;
    private MessageType messageType;
    private LocalDateTime createdTime;
}
