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

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;

    private String reference;

    private Long memberId;

    @Builder
    public MemberChannel(Channel channel, String reference, Long memberId) {
        this.channel = channel;
        this.reference = reference;
        this.memberId = memberId;
    }
}
