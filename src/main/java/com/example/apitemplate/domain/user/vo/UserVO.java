package com.example.apitemplate.domain.user.vo;

import com.example.apitemplate.domain.common.BaseVO;
import com.example.apitemplate.domain.user.dto.UserDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserVO extends BaseVO {
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

}
