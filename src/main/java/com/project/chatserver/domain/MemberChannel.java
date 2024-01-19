package com.project.chatserver.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MemberChannel {
	@Id
	private Long id;

	private Long memberId;
	private Long channelId;
}
