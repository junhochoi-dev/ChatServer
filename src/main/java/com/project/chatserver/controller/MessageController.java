package com.project.chatserver.controller;

import com.project.chatserver.data.MessageDto;
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

    static class TestDto{
        String content;
        Long senderId;
        String nickname;

        public String getContent() {
            return content;
        }

        public Long getSenderId() {
            return senderId;
        }

        public String getNickname() {
            return nickname;
        }
    }
    @MessageMapping("/message/{reference}")
    public void test11(@Payload TestDto testDto, @DestinationVariable String reference){
        log.info("채팅 보내기");

        List<MessageDto> messageDtos = new ArrayList<>();
        MessageDto messageDto = MessageDto.builder()
                .reference(reference)
                .content(testDto.content)
                .memberId(testDto.senderId)
                .nickname(testDto.nickname)
                .build();

        // 디비에 저장
        messageService.saveMessage(messageDto);
        messageDtos.add(messageDto);
        simpMessagingTemplate.convertAndSend("/server/channel/" + reference, ResponseEntity.status(HttpStatus.OK).body(messageDtos));
    }

    @MessageMapping("/message/notification")
    public void test22(@Payload MessageDto messageDto){
        simpMessagingTemplate.convertAndSend("/server/channel/notification", "공지내용");
    }
}
