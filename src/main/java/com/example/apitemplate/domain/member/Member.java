package com.example.apitemplate.domain.member;

import com.example.apitemplate.domain.auth2.Role;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private Role role;
}
