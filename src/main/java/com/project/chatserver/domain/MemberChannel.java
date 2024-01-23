package com.project.chatserver.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
public class MemberChannel {
    @Id
    @GeneratedValue
    private Long id;

    // Member
    private Long memberId;
    private String nickname;

    // Channel
    private Long channelId;
    private String reference;

    @Builder
    public MemberChannel(Long memberId, String nickname, Long channelId, String reference) {
        this.memberId = memberId;
        this.nickname = nickname;
        this.channelId = channelId;
        this.reference = reference;
    }
}
