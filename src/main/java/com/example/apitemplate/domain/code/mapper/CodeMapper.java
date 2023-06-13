package com.example.apitemplate.domain.code.mapper;

import com.example.apitemplate.domain.code.dto.CodeDto;
import com.example.apitemplate.domain.code.vo.CodeVO;
import com.example.apitemplate.domain.user.dto.UserDto;
import com.example.apitemplate.domain.user.vo.UserVO;

public class CodeMapper {
    public static CodeVO toEntity(CodeDto codeDto) {
        return CodeVO.builder()
                .cdId(codeDto.getCdId())
                .prtCdId(codeDto.getPrtCdId())
                .cdNm(codeDto.getCdNm())
                .delYn(codeDto.getDelYn())
                .useYn(codeDto.getUseYn())
                .crtDt(codeDto.getCrtDt())
                .udtDt(codeDto.getUdtDt())
                .crtId(codeDto.getCrtId())
                .udtId(codeDto.getUdtId())
                .build();
        }
}
