package com.project.chatserver.service;

import com.project.chatserver.data.ChannelDto;
import com.project.chatserver.repository.ChannelRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChannelService {
	private final ChannelRepository channelRepository;

	public List<ChannelDto> findChannelListById(Long memberId) {
		return null;
	}
}
