package com.project.chatserver.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.project.chatserver.repository.ChannelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChannelService {

	private final ChannelRepository channelRepository;

	public void createPrivateChannel(Long memberId1, Long memberId2) {
		// 있으면 있는 거 보내주기
		String reference = UUID.randomUUID().toString();
		// 없으면 없는 거 보내주기
			// 각각 MemberChannel 만들기
	}

	public void createPublicChannel(String name) {
		// 같은 이름이 있는 지 확인
		// 없으면 생성해서 제공
		String reference = UUID.randomUUID().toString();
	}
}
