package com.project.chatserver.service;

import com.project.chatserver.data.ChannelDto;
import com.project.chatserver.data.MessageDto;
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

    public List<MessageDto> findMessageListByReference(String reference) {
        List<Message> messages = messageRepository.findAllByReference(reference);
        List<MessageDto> messageDtos = new ArrayList<>();
        for(Message message: messages){
            MessageDto messageDto = MessageDto
                    .builder()
                    .memberId(message.getMemberId())
                    .nickname(message.getNickname())
                    .reference(message.getReference())
                    .content(message.getContent())
                    .createdTime(message .getCreatedTime())
                    .build();
            messageDtos.add(messageDto);
        }
        return messageDtos;
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
