package com.project.chatserver.controller;

import com.project.chatserver.data.ChannelDto;
import com.project.chatserver.data.MessageDto;
import com.project.chatserver.data.request.CreateMultipleChannelRequestDto;
import com.project.chatserver.data.request.CreateSimpleChannelRequestDto;
import com.project.chatserver.data.response.MessageListResponseDto;
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

    private final String BROKERPREFIX = "/server";

    @SubscribeMapping("/channel/connection/{memberId}")
    public void updateChannelList(@DestinationVariable Long memberId) {
        log.info("[CHANNEL] : Update Channel List ({})", memberId);
        // ChannelList
        List<ChannelDto> channelDtoList = channelService.findChannelListByMemberId(memberId);
        simpMessagingTemplate.convertAndSend(BROKERPREFIX + "/channel/connection/" + memberId, ResponseEntity.status(HttpStatus.OK).body(channelDtoList));
    }

    @SubscribeMapping("/channel/{reference}")
    public void updateMessageList(@DestinationVariable String reference) {
        log.info("[CHANNEL] : Update Message List ({})", reference);
        // MessageList
        MessageListResponseDto responseDto = messageService.findMessageListByReference(reference);
        simpMessagingTemplate.convertAndSend(BROKERPREFIX + "/channel/" + reference, ResponseEntity.status(HttpStatus.OK).body(responseDto));
    }

    @MessageMapping("/channel/create/simple")
    public void createSimpleChannel(@Payload CreateSimpleChannelRequestDto requestDto) {
        log.info("[CHANNEL] : SIMPLE CHANNEL CREATE ({}, {})", requestDto.getSenderId(), requestDto.getReceiverId());
        channelService.createSimpleChannel(requestDto);
        updateChannelList(requestDto.getSenderId());
        updateChannelList(requestDto.getReceiverId());
    }

    @MessageMapping("/channel/create/multiple")
    public void createMultipleChannel(@Payload CreateMultipleChannelRequestDto requestDto) {
        log.info("[CHANNEL] : MULTIPLE CHANNEL CREATE ({}, {})", requestDto.getName(), requestDto.getMemberId());
        channelService.createMultipleChannel(requestDto);
        updateChannelList(requestDto.getMemberId());
    }
}
