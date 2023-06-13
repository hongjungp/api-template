package com.example.apitemplate.domain.user.dto;

import com.example.apitemplate.domain.common.BaseDto;
import com.example.apitemplate.domain.common.WorkType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
public class UserDto extends BaseDto {
    private WorkType wrkTp;
    private String usrId;
    private String usrEmail;
    private String pwd;
    private String usrNm;
    private String jumin;
    private String phone;
    private String addr1;
    private String addr2;
    private String remark;
    private String usrAuthId;
    private String lastLogDt;
    private String lastPwdDt;
    private String delYn;
    private String useYn;
//    private String crtDt;
//    private String udtDt;
//    private String crtId;
//    private String udtId;
}
