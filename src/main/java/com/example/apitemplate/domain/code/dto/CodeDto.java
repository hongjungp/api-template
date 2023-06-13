package com.example.apitemplate.domain.code.dto;

import com.example.apitemplate.domain.common.BaseDto;
import com.example.apitemplate.domain.common.BaseVO;
import com.example.apitemplate.domain.common.YN;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CodeDto extends BaseDto {
    private String prtCdId;
    private String cdId;
    private int lvl;
    private String cdNm;
    private YN delYn;
    private YN useYn;
}
