package com.project.chatserver.service;

import com.project.chatserver.data.ChannelDto;
import com.project.chatserver.data.MessageDto;
import com.project.chatserver.data.request.MessageRequestDto;
import com.project.chatserver.data.response.MessageListResponseDto;
import com.project.chatserver.data.response.MessageResponseDto;
import com.project.chatserver.domain.Channel;
import com.project.chatserver.domain.Message;
import com.project.chatserver.repository.MemberRepository;
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
    private final MemberRepository memberRepository;
    private final MessageRepository messageRepository;

    @Transactional(readOnly = true)
    public MessageListResponseDto findMessageListByReference(String reference) {
        List<Message> messageList = messageRepository.findAllByReference(reference);
        MessageListResponseDto responseDto = new MessageListResponseDto();
        for (Message message : messageList) {
            MessageResponseDto messageResponseDto = MessageResponseDto.builder()
                    .content(message.getContent())
                    .messageType(message.getMessageType())
                    .createdTime(message.getCreatedTime())
                    .memberId(message.getMemberId())
                    .channelId(message.getChannelId())
                    .reference(message.getReference())
                    .build();
            messageResponseDto.setNickname(memberRepository.findById(message.getMemberId()).get().getNickname());
            responseDto.getMessageResponseDtoList().add(messageResponseDto);
        }
        return responseDto;
    }

    @Transactional
    public MessageListResponseDto saveMessage(MessageRequestDto requestDto) {
        Message message = Message.builder()
                .content(requestDto.getContent())
                .messageType(requestDto.getMessageType())
                .createdTime(requestDto.getCreatedTime())
                .memberId(requestDto.getMemberId())
                .channelId(requestDto.getChannelId())
                .reference(requestDto.getReference())
                .build();
        messageRepository.save(message);

        MessageListResponseDto responseDto = new MessageListResponseDto();
        MessageResponseDto messageResponseDto = MessageResponseDto.builder()
                .content(requestDto.getContent())
                .messageType(requestDto.getMessageType())
                .createdTime(requestDto.getCreatedTime())
                .memberId(requestDto.getMemberId())
                .channelId(requestDto.getChannelId())
                .reference(requestDto.getReference())
                .build();
        System.out.println("###" + requestDto.getMemberId());
        System.out.println("###" + message.getMemberId());
        messageResponseDto.setNickname(memberRepository.findByMemberId(message.getMemberId()).getNickname());
        responseDto.getMessageResponseDtoList().add(messageResponseDto);
        return responseDto;
    }
}
