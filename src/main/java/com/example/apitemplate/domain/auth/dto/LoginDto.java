package com.example.apitemplate.domain.auth.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginDto {
    private String usrId;
    private String pwd;
}
