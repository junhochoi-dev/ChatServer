package com.project.chatserver.controller;

import com.project.chatserver.data.ChannelDto;
import com.project.chatserver.data.MessageDto;
import com.project.chatserver.service.ChannelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ChannelController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final SimpMessageSendingOperations simpMessageSendingOperations;

    private final ChannelService channelService;

    // pub이 MessageMapping 연결
    @MessageMapping("/channel/{memberId}")
    public void test(@DestinationVariable Long memberId){
        System.out.println("server를 통한 통신");
        simpMessagingTemplate.convertAndSend("/server/channel/1234", "채팅을 쳤습니다");
    }

    // prefix를 제외한 url
    @SubscribeMapping("/channel/{memberId}")
    public void SocketIn(@DestinationVariable Long memberId){
        System.out.println("server를 통한 구독");
        simpMessagingTemplate.convertAndSend("/server/channel/1234", "접속을 환영합니다.");
    }

}
