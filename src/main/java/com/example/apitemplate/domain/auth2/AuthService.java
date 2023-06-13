//package com.example.apitemplate.domain.auth2;
//
//import com.example.apitemplate.domain.member.CreateMemberRequest;
//import com.example.apitemplate.domain.member.Member;
//import com.example.apitemplate.domain.member.MemberService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class AuthService implements UserDetailsService {
//    private final MemberService memberService;
//    private final AuthenticationManagerBuilder authBuilder;
//
//    public Member signup(CreateMemberRequest createMemberRequest) {
//        Role role = Role.MEMBER;
////        Role role = Role.ADMIN;
//        return memberService.createMember(createMemberRequest, role);
//    }
//
//    public Long login(LoginRequest loginRequest) {
//        Member member = memberService.findByEmailMember(loginRequest.getEmail());
//        boolean matches = memberService.isPasswordMatches(loginRequest.getPassword(), member.getPassword());
//        if (!matches) {
//            System.out.println("비밀번호가 일치하지 않습니다.");
//            return null;
//        }
//        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());
//        Authentication auth = generateAuthentication(authToken);
//        storeAuthenticationInSession(auth);
//        System.out.println(member);
//        System.out.println(member.getId());
//        return member.getId();
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Member member = memberService.findByEmailMember(username);
//        UserDetails userDetails = new CustomUserDetails(member);
//        return userDetails;
//    }
//    private Authentication generateAuthentication(UsernamePasswordAuthenticationToken authToken){
//        return authBuilder.getObject().authenticate(authToken);
//    }
//
//    private void storeAuthenticationInSession(Authentication authentication) {
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//    }
//}
