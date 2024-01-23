package com.project.chatserver.service;

import com.project.chatserver.data.ChannelDto;
import com.project.chatserver.data.MessageDto;
import com.project.chatserver.data.response.MessageListResponseDto;
import com.project.chatserver.domain.Channel;
import com.project.chatserver.domain.Message;
import com.project.chatserver.repository.MessageRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MessageService {
	private final MessageRepository messageRepository;

	@Transactional(readOnly = true)
	public MessageListResponseDto findMessageListByReference(String reference) {
		List<Message> messageList = messageRepository.findAllByReference(reference);
		MessageListResponseDto responseDto = new MessageListResponseDto();
		for (Message message : messageList) {
			MessageDto messageDto = MessageDto.builder()
				.content(message.getContent())
				.messageType(message.getMessageType())
				.createdTime(message.getCreatedTime())
				.memberId(message.getMemberId())
				.nickname(message.getNickname())
				.channelId(message.getChannelId())
				.reference(message.getReference())
				.build();
			responseDto.getMessageDtoList().add(messageDto);
		}
		return responseDto;
	}

	@Transactional
	public void saveMessage(MessageDto messageDto) {
		Message message = Message.builder()
			.memberId(messageDto.getMemberId())
			.content(messageDto.getContent())
			.reference(messageDto.getReference())
			.createdTime(LocalDateTime.now())
			.build();
		messageRepository.save(message);
	}
}
