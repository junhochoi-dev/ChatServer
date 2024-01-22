package com.project.chatserver.domain.linktable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class MultipleChannel {
    @Id
    @GeneratedValue
    private Long id;

    private Long channelId;
    private String reference;

    private Long memberId;

    @Builder
    public MultipleChannel(Long channelId, String reference, Long memberId) {
        this.channelId = channelId;
        this.reference = reference;
        this.memberId = memberId;
    }
}
