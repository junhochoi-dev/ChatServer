package com.project.chatserver.controller;

import com.project.chatserver.service.ChatChannelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ChatChannelController {
    private final ChatChannelService chatChannelService;

    private ArrayList<String> channelList = new ArrayList<>();

    @GetMapping("/channel/create")
    public String create(){
        String channel = UUID.randomUUID().toString();
        channelList.add(channel);
        return channel;
    }

    @GetMapping("/channel/list")
    public List<String> list(){
        return channelList;
    }
}