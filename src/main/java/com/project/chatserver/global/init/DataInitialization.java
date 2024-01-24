package com.project.chatserver.global.init;

import com.project.chatserver.domain.Channel;
import com.project.chatserver.domain.Member;
import com.project.chatserver.domain.MemberChannel;
import com.project.chatserver.domain.Message;
import com.project.chatserver.domain.type.AccessType;
import com.project.chatserver.domain.type.ChannelType;
import com.project.chatserver.domain.type.MessageType;
import com.project.chatserver.repository.ChannelRepository;
import com.project.chatserver.repository.MemberChannelRepository;
import com.project.chatserver.repository.MemberRepository;
import com.project.chatserver.repository.MessageRepository;
import jakarta.annotation.PostConstruct;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class DataInitialization {
    private final MemberRepository memberRepository;
    private final MessageRepository messageRepository;
    private final ChannelRepository channelRepository;
    private final MemberChannelRepository memberChannelRepository;

    @PostConstruct
    private void postConstruct() {
        Member member1 = new Member(97531677L, "김태규");
        Member member2 = new Member(64817041L, "김정욱");
        Member member3 = new Member(27275274L, "윤설");
        Member member4 = new Member(91579680L, "오희주");
        Member member5 = new Member(77108539L, "최준호");
        Member member6 = new Member(29934527L, "황주영");
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);
        memberRepository.save(member5);
        memberRepository.save(member6);

        Channel channel1 = new Channel("8생활관 6공주", "communitiy", AccessType.PUBLIC, ChannelType.MULTIPLE);
        channelRepository.save(channel1);

        MemberChannel memberChannel1 = MemberChannel.builder()
                .channelId(channel1.getId()).reference(channel1.getReference())
                .memberId(member1.getId()).build();
        MemberChannel memberChannel2 = MemberChannel.builder()
                .channelId(channel1.getId()).reference(channel1.getReference())
                .memberId(member2.getId()).build();
        MemberChannel memberChannel3 = MemberChannel.builder()
                .channelId(channel1.getId()).reference(channel1.getReference())
                .memberId(member3.getId()).build();
        MemberChannel memberChannel4 = MemberChannel.builder()
                .channelId(channel1.getId()).reference(channel1.getReference())
                .memberId(member4.getId()).build();
        MemberChannel memberChannel5 = MemberChannel.builder()
                .channelId(channel1.getId()).reference(channel1.getReference())
                .memberId(member5.getId()).build();
        MemberChannel memberChannel6 = MemberChannel.builder()
                .channelId(channel1.getId()).reference(channel1.getReference())
                .memberId(member6.getId()).build();
        memberChannelRepository.save(memberChannel1);
        memberChannelRepository.save(memberChannel2);
        memberChannelRepository.save(memberChannel3);
        memberChannelRepository.save(memberChannel4);
        memberChannelRepository.save(memberChannel5);
        memberChannelRepository.save(memberChannel6);
    }
}
