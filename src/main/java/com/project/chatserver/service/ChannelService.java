package com.project.chatserver.service;

import java.util.List;
import java.util.UUID;

import com.project.chatserver.data.ChannelDto;
import org.springframework.stereotype.Service;

import com.project.chatserver.repository.ChannelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChannelService {

	private final ChannelRepository channelRepository;

}
