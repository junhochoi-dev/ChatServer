package com.project.chatserver.controller;

import com.project.chatserver.data.request.MemberRequestDto;
import com.project.chatserver.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public ResponseEntity<?> manageMember(@RequestBody MemberRequestDto requestDto){
        memberService.manageMember(requestDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
