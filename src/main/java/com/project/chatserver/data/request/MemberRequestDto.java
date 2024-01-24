package com.project.chatserver.data.request;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequestDto {
    private Long memberId;
    private String nickname;
}
