package com.project.chatserver.controller;

import com.project.chatserver.data.MessageDto;
import com.project.chatserver.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin("*")
@RequiredArgsConstructor
@Slf4j
public class MessageController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final MessageService messageService;

    @MessageMapping("/message/notification")
    public void test(@Payload MessageDto messageDto){
        simpMessagingTemplate.convertAndSend("/server/channel/notification", "공지내용");
    }

    // 공통 커뮤니티
    @MessageMapping("/message/public")
    public void testtest1(@Payload MessageDto messageDto){
        log.info(messageDto.toString());
        messageService.saveMessage(messageDto);
        simpMessagingTemplate.convertAndSend("/server/channel/public", "메세지");
    }

    // Reference를 통한 메세지 전송
    @MessageMapping("/message/{reference}")
    public void testtest2(@DestinationVariable String reference, @Payload MessageDto messageDto){
        log.info(messageDto.toString());
        messageService.saveMessage(messageDto);
        simpMessagingTemplate.convertAndSend("/server/channel/" + reference, "메세지");
    }

}
