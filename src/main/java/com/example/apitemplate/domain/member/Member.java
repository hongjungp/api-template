package com.example.apitemplate.domain.member;

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
}
