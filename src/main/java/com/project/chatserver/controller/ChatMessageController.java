package com.project.chatserver.controller;

import com.project.chatserver.dto.ChatMessageDto;
import com.project.chatserver.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ChatMessageController {

    private final SimpUserRegistry simpUserRegistry;
    private final SimpMessagingTemplate simpMessagingTemplate;

    private final ChatMessageService chatMessageService;
    @MessageMapping(value = "/test")
    public void test(ChatMessageDto chatMessageDto){
        //chatMessageDto.setContent("TEST");
        System.out.println("SEND SUCCESS");
        simpMessagingTemplate.convertAndSend("/subscription/test", chatMessageDto);
    }
    @MessageMapping(value = "/channel/in")
    public void channelIn(ChatMessageDto chatMessageDto){
        chatMessageDto.setContent(chatMessageDto.getNickname() + "님이 채팅방에 참여하였습니다 :)");
        simpMessagingTemplate.convertAndSend("/subscription/test", chatMessageDto);
    }

//    @MessageMapping(value = "/channel/out")
//    public void channelOut(ChatMessageDto chatMessageDto){
//        //chatMessageDto.setContent(chatMessageDto.getSender() + "님이 채팅방에 퇴장하였습니다 :(");
//        simpMessagingTemplate.convertAndSend("/pub/channel/" + chatMessageDto.getChannel(), chatMessageDto);
//    }

//    @MessageMapping(value = "/chat/message")
//    public void message(ChatMessageDto chatMessageDto){
//        simpMessagingTemplate.convertAndSend("/sub/chat/room/" + chatMessageDto.getChannel(), chatMessageDto);
//    }
}
