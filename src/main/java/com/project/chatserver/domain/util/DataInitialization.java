package com.project.chatserver.domain.util;

import com.project.chatserver.domain.linktable.MultipleChannel;
import com.project.chatserver.domain.linktable.SimpleChannel;
import com.project.chatserver.repository.MultipleChannelRepository;
import com.project.chatserver.repository.SimpleChannelRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitialization {
    @Autowired
    private SimpleChannelRepository simpleChannelRepository;
    @Autowired
    private MultipleChannelRepository multipleChannelRepository;

    @PostConstruct
    private void postConstruct(){
        SimpleChannel simpleChannel1 = SimpleChannel
                .builder()
                .channelId(1L)
                .reference("ABCD")
                .memberId1(1234L)
                .memberId2(5678L)
                .build();
        simpleChannelRepository.save(simpleChannel1);

        MultipleChannel multipleChannel1 = MultipleChannel
                .builder()
                .channelId(2L)
                .reference("EFGH")
                .memberId(1234L)
                .build();
        multipleChannelRepository.save(multipleChannel1);
    }

}
