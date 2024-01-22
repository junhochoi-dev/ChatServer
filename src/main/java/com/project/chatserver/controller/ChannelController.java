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

    private final ChannelService channelService;

    @SubscribeMapping("/channel/{memberId}")
    public void test1(@DestinationVariable Long memberId){
        System.out.println("server를 통한 구독");
        simpMessagingTemplate.convertAndSend("/server/channel/1234", "웹소켓리스트 제공");
    }

    @MessageMapping("/channel/search/simple")
    public void test2(@RequestBody Long memberId){
        System.out.println("server를 통한 통신");
        simpMessagingTemplate.convertAndSend("/server/channel/1234", "채팅을 쳤습니다");
    }

    @MessageMapping("/channel/search/multiple")
    public void test3(@RequestBody String name){
        System.out.println("server를 통한 통신");
        simpMessagingTemplate.convertAndSend("/server/channel/1234", "커뮤니티 채팅방리스트");
    }

    @MessageMapping("/channel/create/simple")
    public void test4(@RequestBody Long memberId1, @RequestBody Long memberId2){
        // MemberChannel 있는 지 확인
            // 있으면 그대로 reference 반환
            // 없으면 reference 생성 후
    }

    @MessageMapping("/channel/create/multiple")
    public void test5(@RequestBody String name){

    }

    // 로그인 시, 채널리스트 반환
    // 온라인 시, 채널리스트 갱신
    // 록아웃 시,
}
