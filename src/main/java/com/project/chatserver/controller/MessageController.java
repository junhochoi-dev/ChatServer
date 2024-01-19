package com.project.chatserver.controller;

import com.project.chatserver.data.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin("*")
@Slf4j
public class MessageController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    // @MessageMapping("/message")
    // @SendTo("/chatroom/public")
    // public MessageDto receiveMessage(@Payload MessageDto messageDto){
    //     log.info(messageDto.toString());
    //     return messageDto;
    // }
    //
    // @MessageMapping("/private-message")
    // public MessageDto recMessage(@Payload MessageDto messageDto){
    //     simpMessagingTemplate.convertAndSendToUser(messageDto.getReceiverName(),"/private",messageDto);
    //     log.info(messageDto.toString());
    //     return messageDto;
    // }
}
