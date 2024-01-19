package com.project.chatserver.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MemberChannel {
	@Id
	private Long id;
	private Long 멤버아이디;

	private Long 채널아이디;
}
