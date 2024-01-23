package com.project.chatserver.global.init;

import com.project.chatserver.domain.Channel;
import com.project.chatserver.domain.MemberChannel;
import com.project.chatserver.domain.Message;
import com.project.chatserver.domain.type.AccessType;
import com.project.chatserver.domain.type.ChannelType;
import com.project.chatserver.domain.type.MessageType;
import com.project.chatserver.repository.ChannelRepository;
import com.project.chatserver.repository.MemberChannelRepository;
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
    private final MessageRepository messageRepository;
    private final ChannelRepository channelRepository;
    private final MemberChannelRepository memberChannelRepository;

    @PostConstruct
    private void postConstruct() {
        Channel channel1 = new Channel("김태규님과 김단이님의 채팅방", "ABC", AccessType.PUBLIC, ChannelType.SINGLE);
        Channel channel2 = new Channel("김태규님과 윤설님의 채팅방", "DEF", AccessType.PUBLIC, ChannelType.SINGLE);
        Channel channel3 = new Channel("김태규님과 오희주님의 채팅방", "GHI", AccessType.PUBLIC, ChannelType.SINGLE);
        channelRepository.save(channel1);
        channelRepository.save(channel2);
        channelRepository.save(channel3);

        MemberChannel memberChannel1 = MemberChannel.builder().memberId(123L).reference("ABC").build();
        MemberChannel memberChannel2 = MemberChannel.builder().memberId(123L).reference("DEF").build();
        MemberChannel memberChannel3 = MemberChannel.builder().memberId(123L).reference("GHI").build();
        memberChannelRepository.save(memberChannel1);
        memberChannelRepository.save(memberChannel2);
        memberChannelRepository.save(memberChannel3);

        Message message1 = Message.builder().memberId(123L).nickname("김태규").content("아 입실하기 안눌렀다").createdTime(LocalDateTime.now()).messageType(MessageType.MESSAGE_TXT).build();
        Message message2 = Message.builder().memberId(456L).nickname("김단이").content("사유서 제출하세요!").createdTime(LocalDateTime.now()).messageType(MessageType.MESSAGE_TXT).build();
        Message message3 = Message.builder().memberId(123L).nickname("김태규").content("이닦고 올게요!").createdTime(LocalDateTime.now()).messageType(MessageType.MESSAGE_TXT).build();
        messageRepository.save(message1);
        messageRepository.save(message2);
        messageRepository.save(message3);


//        Channel c1 = Channel.builder()
//                .name("김태규와 김단이의 채팅방").reference("ABCD").accessType(AccessType.PUBLIC).channelType(ChannelType.SINGLE).build();
//        channelRepository.save(c1);
//        Channel c2 = Channel.builder()
//                .name("김태규와 윤설의 채팅방").reference("EFGH").accessType(AccessType.PUBLIC).channelType(ChannelType.SINGLE).build();
//        channelRepository.save(c2);
//        Channel c3 = Channel.builder()
//                .name("김태규와 오희주의 채팅방").reference("QSIW").accessType(AccessType.PUBLIC).channelType(ChannelType.SINGLE).build();
//        channelRepository.save(c3);
//        Channel c4 = Channel.builder()
//                .name("김태규의 홀로 채팅방").reference("AIOW").accessType(AccessType.PUBLIC).channelType(ChannelType.SINGLE).build();
//        channelRepository.save(c4);
    }
}
