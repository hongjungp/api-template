package com.example.apitemplate.domain.auth.vo;

import com.example.apitemplate.domain.common.BaseVO;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthVO extends BaseVO {
    private String authId;
    private String authNm;
}
