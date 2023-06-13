package com.example.apitemplate.domain.auth.mapper;

import com.example.apitemplate.domain.auth.dto.AuthDto;
import com.example.apitemplate.domain.auth.vo.AuthVO;
import com.example.apitemplate.domain.menu.dto.MenuDto;
public class AuthMapper {
    public static AuthVO toEntity(AuthDto authDto){
        return AuthVO.builder()
                .authId(authDto.getAuthId())
                .authNm(authDto.getAuthNm())
                .crtDt(authDto.getCrtDt())
                .udtDt(authDto.getUdtDt())
                .crtId(authDto.getCrtId())
                .udtId(authDto.getUdtId())
                .build();
    }
}
