package com.example.apitemplate.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member createMember(CreateMemberRequest createMemberRequest){
        Member member = Member.builder()
                .email(createMemberRequest.getEmail())
                .password(passwordEncoder.encode(createMemberRequest.getPassword()))
                .nickname(createMemberRequest.getNickname())
                .build();
        memberRepository.createMember(member);
        return member;
    }
    public Member findByIdMember(Long id){
        return memberRepository.findByIdMember(id);
    }

    public Member findByEmailMember(String email){
        return memberRepository.findByEmailMember(email);
    }
    public boolean isPasswordMatches(String password, String storedPassword){
        return passwordEncoder.matches(password, storedPassword);
    }
}
