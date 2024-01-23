package com.project.chatserver.service;

import com.project.chatserver.data.ChannelDto;
import com.project.chatserver.domain.Channel;
import com.project.chatserver.domain.MemberChannel;
import com.project.chatserver.repository.ChannelRepository;
import com.project.chatserver.repository.MemberChannelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
            ChannelDto channelDto = ChannelDto.builder().reference(memberChannel.getReference()).build();
            channelDtos.add(channelDto);
        }
        return channelDtos;
    }

    @Transactional
    public void createSimpleChannel(Long memberId1, Long memberId2) {
        String reference = memberId1 < memberId2
                ? memberId1.toString() + "&" + memberId2.toString()
                : memberId2.toString() + "&" + memberId1.toString();
        Channel channel = channelRepository.findByReference(reference);
        if (channel == null) {
            channel = Channel.builder().name(memberId1.toString() + "과" + memberId2.toString() + "의 채팅방").reference(reference).build();
            channelRepository.save(channel);
        }

        MemberChannel memberChannel1 = MemberChannel.builder().memberId(memberId1).reference(reference).build();
        MemberChannel memberChannel2 = MemberChannel.builder().memberId(memberId2).reference(reference).build();
        memberChannelRepository.save(memberChannel1);
        memberChannelRepository.save(memberChannel2);
    }
}
