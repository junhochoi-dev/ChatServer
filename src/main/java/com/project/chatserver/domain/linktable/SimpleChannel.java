package com.project.chatserver.domain.linktable;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
public class SimpleChannel {
    @Id
    @GeneratedValue
    private Long id;

    private Long channelId;
    private String reference;

    private Long memberId1;
    private Long memberId2;

    @Builder
    public SimpleChannel(Long channelId, String reference, Long memberId1, Long memberId2) {
        this.channelId = channelId;
        this.reference = reference;
        this.memberId1 = memberId1;
        this.memberId2 = memberId2;
    }
}
