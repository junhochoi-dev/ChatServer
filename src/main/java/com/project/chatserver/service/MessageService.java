package com.project.chatserver.service;

import com.project.chatserver.data.MessageDto;
import com.project.chatserver.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    public void saveMessage(MessageDto messageDto) {
        //messageRepository.save();
    }
}
