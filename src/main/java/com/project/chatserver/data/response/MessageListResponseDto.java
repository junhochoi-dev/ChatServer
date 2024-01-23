package com.project.chatserver.data.response;

import java.util.ArrayList;
import java.util.List;

import com.project.chatserver.data.ChannelDto;
import com.project.chatserver.data.MessageDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageListResponseDto {

	List<MessageDto> messageDtoList;

	public MessageListResponseDto() {
		this.messageDtoList = new ArrayList<>();
	}
}
