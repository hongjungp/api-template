package com.example.apitemplate.domain.auth.dto;

import com.example.apitemplate.domain.common.BaseDto;
import com.example.apitemplate.domain.common.BaseVO;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthDto extends BaseDto {
    private String authId;
    private String authNm;
}
