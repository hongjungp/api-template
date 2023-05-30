package com.example.apitemplate.domain.auth;

import com.example.apitemplate.domain.member.CreateMemberRequest;
import com.example.apitemplate.domain.member.Member;
import com.example.apitemplate.domain.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final MemberService memberService;

    public Member signup(CreateMemberRequest createMemberRequest) {
        return memberService.createMember(createMemberRequest);
    }

    public Long login(LoginRequest loginRequest) {

        Member member = memberService.findByEmailMember(loginRequest.getEmail());
        boolean matches = memberService.isPasswordMatches(loginRequest.getPassword(), member.getPassword());
        if (!matches) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return null;
        }
        return member.getId();
    }
}
