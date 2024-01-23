package com.project.chatserver.service;

import com.project.chatserver.data.ChannelDto;
import com.project.chatserver.domain.Channel;
import com.project.chatserver.domain.MemberChannel;
import com.project.chatserver.repository.ChannelRepository;
import com.project.chatserver.repository.MemberChannelRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ChannelService {
    private final ChannelRepository channelRepository;
    private final MemberChannelRepository memberChannelRepository;

    public List<ChannelDto> findChannelListByMemberId(Long memberId) {
        List<MemberChannel> memberChannels = memberChannelRepository.findAllByMemberId(memberId);
        List<ChannelDto> channelDtos = new ArrayList<>();
        for (MemberChannel memberChannel : memberChannels) {
            ChannelDto channelDto = ChannelDto.builder()
                    .name(memberChannel.getChannel().getName())
                    .channel(memberChannel.getChannel())
                    .reference(memberChannel.getReference())
                    .build();
            channelDtos.add(channelDto);
        }
        return channelDtos;
    }

    public void createSimpleChannel(Long memberId1, Long memberId2) {
        String reference = memberId1 < memberId2 ? memberId1.toString() + memberId2.toString() : memberId2.toString() + memberId1.toString();
        if(channelRepository.findBy())
    }
}
