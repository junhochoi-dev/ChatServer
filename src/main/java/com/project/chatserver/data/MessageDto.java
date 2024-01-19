package com.project.chatserver.data;

import com.project.chatserver.MessageType;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MessageDto {
    private String senderName;
    private String receiverName;
    private String message;
    private String date;
    private MessageType type;
}
