package com.project.chatserver.data.response;

import java.util.ArrayList;
import java.util.List;

import com.project.chatserver.data.ChannelDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChannelListResponseDto {

	List<ChannelDto> channelDtoList;

	public ChannelListResponseDto() {
		this.channelDtoList = new ArrayList<>();
	}
}
