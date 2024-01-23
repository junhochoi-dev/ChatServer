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
		List<Channel> channels = channelRepository.findAllById(memberId);
		List<ChannelDto> channelDtos = new ArrayList<>();
		for(Channel channel: channels){
			System.out.println(channel.getName());
			channelDtos.add(mapper.map(channel, ChannelDto.class));
		}
		return channelDtos;
	}
}
