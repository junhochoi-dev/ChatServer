package com.project.chatserver.controller;

import com.project.chatserver.data.ChannelDto;
import com.project.chatserver.data.MessageDto;
import com.project.chatserver.service.ChannelService;
import com.project.chatserver.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@Slf4j
public class ChannelController {
    private final SimpMessagingTemplate simpMessagingTemplate;

    private final ChannelService channelService;
    private final MessageService messageService;

    static class TestDto {
        Long senderId;
        Long receiverId;

        public Long getSenderId() {
            return senderId;
        }

        public Long getReceiverId() {
            return receiverId;
        }
    }

    @SubscribeMapping("/channel/notification/{memberId}")
    public void function01(@DestinationVariable Long memberId) {
        log.info("채팅창 전체 리스트 받기 ");
        List<ChannelDto> channelDtos = channelService.findChannelListByMemberId(memberId);
        simpMessagingTemplate.convertAndSend("/server/channel/notification/" + memberId, ResponseEntity.status(HttpStatus.OK).body(channelDtos));
    }

    @SubscribeMapping("/channel/{reference}")
    public void function02(@DestinationVariable String reference) {
        log.info("전체 채팅 로그 받기");
        List<MessageDto> messageDtos = messageService.findMessageListByReference(reference);
        simpMessagingTemplate.convertAndSend("/server/channel/" + reference, ResponseEntity.status(HttpStatus.OK).body(messageDtos));
    }

    @MessageMapping("/channel/create/simple")
    public void function03(@Payload TestDto testDto) {
        log.info("단일 채팅방 생성");
        Long memberId1 = testDto.getSenderId();
        Long memberId2 = testDto.getReceiverId();

        channelService.createSimpleChannel(memberId1, memberId2);
        function01(memberId1);
        function01(memberId2);
    }

    @Deprecated
    @MessageMapping("/channel/search/simple")
    public void test2(@RequestBody Long memberId) {
        System.out.println("server를 통한 통신");
        simpMessagingTemplate.convertAndSend("/server/channel/1234", "채팅을 쳤습니다");
    }

    @MessageMapping("/channel/search/multiple")
    public void test3(@RequestBody String name) {
        System.out.println("server를 통한 통신");
        simpMessagingTemplate.convertAndSend("/server/channel/1234", "커뮤니티 채팅방리스트");
    }

    @MessageMapping("/channel/create/multiple")
    public void test5(@RequestBody String name) {

    }

    // 로그인 시, 채널리스트 반환
    // 온라인 시, 채널리스트 갱신
    // 록아웃 시,
}
