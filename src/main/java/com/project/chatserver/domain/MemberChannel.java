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

    // Channel
    private Long channelId;
    private String reference;

    @Builder
    public MemberChannel(Long memberId, Long channelId, String reference) {
        this.memberId = memberId;
        this.channelId = channelId;
        this.reference = reference;
    }
}
