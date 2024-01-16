package com.project.chatserver.controller;

import com.project.chatserver.dto.ChatMessageDto;
import com.project.chatserver.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ChatMessageController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    private final ChatMessageService chatMessageService;

    @MessageMapping(value = "/chat/enter")
    public void enter(ChatMessageDto chatMessageDto){
        chatMessageDto.setContent(chatMessageDto.getSender() + "님이 채팅방에 참여하였습니다.");

        System.out.println(LocalDateTime.now());
        System.out.println(chatMessageDto.getSender());
        System.out.println(chatMessageDto.getContent());

        log.info(String.valueOf(LocalDateTime.now()));
        log.info(chatMessageDto.getSender());
        log.info(chatMessageDto.getContent());

        simpMessagingTemplate.convertAndSend("/sub/chat/room/" + chatMessageDto.getChannel(), chatMessageDto);
    }

    @MessageMapping(value = "/chat/message")
    public void message(ChatMessageDto chatMessageDto){
        simpMessagingTemplate.convertAndSend("/sub/chat/room/" + chatMessageDto.getChannel(), chatMessageDto);
    }
}
