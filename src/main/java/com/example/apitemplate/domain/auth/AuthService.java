package com.example.apitemplate.domain.auth;

import com.example.apitemplate.domain.member.CreateMemberRequest;
import com.example.apitemplate.domain.member.Member;
import com.example.apitemplate.domain.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final MemberService memberService;

    public Member signup(CreateMemberRequest createMemberRequest){
        return memberService.createMember(createMemberRequest);
    }
}
