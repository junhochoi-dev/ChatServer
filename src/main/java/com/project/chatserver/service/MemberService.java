package com.project.chatserver.service;

import com.project.chatserver.data.request.MemberRequestDto;
import com.project.chatserver.domain.Member;
import com.project.chatserver.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public void manageMember(MemberRequestDto requestDto) {
        Member member = memberRepository.findById(requestDto.getMemberId()).get();
        if(member == null){
            member = new Member(requestDto.getMemberId(), requestDto.getNickname());
            memberRepository.save(member);
            return;
        }
        member.updateNickname(requestDto.getNickname());
    }
}
