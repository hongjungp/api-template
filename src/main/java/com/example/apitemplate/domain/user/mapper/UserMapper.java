package com.example.apitemplate.domain.user.mapper;

import com.example.apitemplate.domain.user.dto.UserDto;
import com.example.apitemplate.domain.user.vo.UserVO;

import java.time.LocalDateTime;
import java.util.Date;

public class UserMapper {
    public static UserVO toEntity(UserDto userDto) {
        return UserVO.builder()
                .usrId(userDto.getUsrId())
                .usrEmail(userDto.getUsrEmail())
                .pwd(userDto.getPwd())
                .usrNm(userDto.getUsrNm())
                .jumin(userDto.getJumin())
                .phone(userDto.getPhone())
                .addr1(userDto.getAddr1())
                .addr2(userDto.getAddr2())
                .remark(userDto.getRemark())
                .usrAuthId(userDto.getUsrAuthId())
                .lastLogDt(userDto.getLastLogDt())
                .lastPwdDt(userDto.getLastPwdDt())
                .delYn(userDto.getDelYn())
                .useYn(userDto.getUseYn())
                .crtDt(userDto.getCrtDt())
                .udtDt(userDto.getUdtDt())
                .crtId(userDto.getCrtId())
                .udtId(userDto.getUdtId())
                .build();
        }
}
