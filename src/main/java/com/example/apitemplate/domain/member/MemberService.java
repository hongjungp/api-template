package com.example.apitemplate.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member createMember(CreateMemberRequest createMemberRequest){
        Member member = Member.builder()
                .email(createMemberRequest.getEmail())
                .password(createMemberRequest.getPassword())
                .nickname(createMemberRequest.getNickname())
                .build();
        memberRepository.createMember(member);
        return member;
    }
}
