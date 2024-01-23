package com.project.chatserver.controller;

import com.project.chatserver.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final ChannelService channelService;
    @PostMapping("/test")
    public ResponseEntity<?> channelList(){
        System.out.println("TEST");
        return ResponseEntity.status(HttpStatus.OK).body(channelService.findChannelListByMemberId(123L));
    }
}
