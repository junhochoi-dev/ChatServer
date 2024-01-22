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
        Channel c1 = Channel.builder()
                .name("김태규와 김단이의 채팅방").reference("ABCD").accessType(AccessType.PUBLIC).channelType(ChannelType.SINGLE).build();
        channelRepository.save(c1);
        Channel c2 = Channel.builder()
                .name("김태규와 윤설의 채팅방").reference("EFGH").accessType(AccessType.PUBLIC).channelType(ChannelType.SINGLE).build();
        channelRepository.save(c2);
        Channel c3 = Channel.builder()
                .name("김태규와 오희주의 채팅방").reference("QSIW").accessType(AccessType.PUBLIC).channelType(ChannelType.SINGLE).build();
        channelRepository.save(c3);
        Channel c4 = Channel.builder()
                .name("김태규의 홀로 채팅방").reference("AIOW").accessType(AccessType.PUBLIC).channelType(ChannelType.SINGLE).build();
        channelRepository.save(c4);
    }
}
