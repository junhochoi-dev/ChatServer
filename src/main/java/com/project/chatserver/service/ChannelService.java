package com.project.chatserver.service;

import com.project.chatserver.data.ChannelDto;
import com.project.chatserver.data.request.CreateMultipleChannelRequestDto;
import com.project.chatserver.data.request.CreateSimpleChannelRequestDto;
import com.project.chatserver.domain.Channel;
import com.project.chatserver.domain.MemberChannel;
import com.project.chatserver.domain.type.AccessType;
import com.project.chatserver.domain.type.ChannelType;
import com.project.chatserver.repository.ChannelRepository;
import com.project.chatserver.repository.MemberChannelRepository;
import com.project.chatserver.repository.MemberRepository;
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
    private final MemberRepository memberRepository;
    private final ChannelRepository channelRepository;
    private final MemberChannelRepository memberChannelRepository;

    public List<ChannelDto> findChannelListByMemberId(Long memberId) {
        List<MemberChannel> memberChannelList = memberChannelRepository.findAllByMemberId(memberId);
        List<ChannelDto> channelDtoList = new ArrayList<>();
        for (MemberChannel memberChannel : memberChannelList) {
            Channel channel = channelRepository.findByReference(memberChannel.getReference());
            ChannelDto channelDto = ChannelDto.builder()
                    // MemberId와 ChannelType에 따라 분기
                    //.name()
                    .accessType(channel.getAccessType())
                    .channelType(channel.getChannelType())
                    .createdTime(channel.getCreatedTime())
                    .updatedTime(channel.getUpdatedTime())
                    .build();
            if (channel.getChannelType() == ChannelType.SIMPLE) {
                Long oppositeId = memberChannelRepository.findByMemberIdNotAndReference(memberId, memberChannel.getReference()).getMemberId();
                String nickname = memberRepository.findById(oppositeId).get().getNickname();
                channelDto.setName(nickname);
            }
            if (channel.getChannelType() == ChannelType.MULTIPLE) {
                channelDto.setName(channel.getName());
            }
            channelDtoList.add(channelDto);
        }
        return channelDtoList;
    }

    @Transactional
    public void createSimpleChannel(CreateSimpleChannelRequestDto requestDto) {
        Long memberId1 = requestDto.getSenderId();
        Long memberId2 = requestDto.getReceiverId();
        // 임시 생성 RE
        String reference = memberId1 < memberId2
                ? memberId1.toString() + "&" + memberId2.toString()
                : memberId2.toString() + "&" + memberId1.toString();
        Channel channel = channelRepository.findByReference(reference);
        if (channel == null) {
            channel = Channel.builder()
                    .name(memberId1.toString() + "과" + memberId2.toString() + "의 채팅방").reference(reference)
                    .channelType(ChannelType.SIMPLE).accessType(AccessType.PRIVATE).build();
            channelRepository.save(channel);
            MemberChannel memberChannel1 = MemberChannel.builder().channelId(channel.getId()).reference(reference).memberId(memberId1).build();
            MemberChannel memberChannel2 = MemberChannel.builder().channelId(channel.getId()).reference(reference).memberId(memberId2).build();
            memberChannelRepository.save(memberChannel1);
            memberChannelRepository.save(memberChannel2);
        }
    }

    public void createMultipleChannel(CreateMultipleChannelRequestDto requestDto) {

    }
}
