package com.project.chatserver.domain;

import jakarta.persistence.*;

@Entity
public class MemberChannel {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Channel channel;

    private String reference;

    private Long memberId;
}
