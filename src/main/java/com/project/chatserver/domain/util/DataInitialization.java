package com.project.chatserver.domain.util;

import com.project.chatserver.domain.Channel;
import com.project.chatserver.domain.type.AccessType;
import com.project.chatserver.domain.type.ChannelType;
import com.project.chatserver.repository.ChannelRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitialization {
    private final ChannelRepository channelRepository;

    @PostConstruct
    private void postConstruct(){
        Channel channel1 = new Channel("김태규와 윤설의 채팅방", "ABCD", AccessType.PUBLIC, ChannelType.SINGLE);
        channelRepository.save(channel1);
        Channel channel2 = new Channel("김태규와 김정욱의 채팅방", "DEFG", AccessType.PUBLIC, ChannelType.SINGLE);
        channelRepository.save(channel2);
    }

}
