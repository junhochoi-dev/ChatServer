package com.project.chatserver.service;

import com.project.chatserver.data.ChannelDto;
import com.project.chatserver.domain.Channel;
import com.project.chatserver.repository.ChannelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChannelService {
	private final ChannelRepository channelRepository;

	public List<ChannelDto> findChannelListById(Long memberId) {
		ModelMapper mapper = new ModelMapper();
		Optional<Channel> channels = channelRepository.findById(memberId);
		List<ChannelDto> channelDtos = new ArrayList<>();
		if(channels.isPresent()){
			for(Channel channel: channels.stream().toList()){
				channelDtos.add(mapper.map(channel, ChannelDto.class));
			}
		}
		return channelDtos;
	}
}
