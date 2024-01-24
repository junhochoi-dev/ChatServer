package com.project.chatserver.controller;

import com.project.chatserver.data.MessageDto;
import com.project.chatserver.data.request.MessageRequestDto;
import com.project.chatserver.data.response.MessageListResponseDto;
import com.project.chatserver.domain.Channel;
import com.project.chatserver.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin("*")
@RequiredArgsConstructor
@Slf4j
public class MessageController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final MessageService messageService;

    @MessageMapping("/message/{reference}")
    public void createMessage(@Payload MessageRequestDto requestDto, @DestinationVariable String reference){
        log.info("[Message] Message Create ({}, {})", requestDto.getMemberId(), requestDto.getChannelId());
        MessageListResponseDto responseDto = messageService.saveMessage(requestDto);
        simpMessagingTemplate.convertAndSend("/server/channel/" + reference, ResponseEntity.status(HttpStatus.OK).body(responseDto));
    }
}
