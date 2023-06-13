package com.example.apitemplate.domain.code.vo;

import com.example.apitemplate.domain.common.BaseVO;
import com.example.apitemplate.domain.common.YN;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CodeVO extends BaseVO {
    private String prtCdId;
    private String cdId;
    private int lvl;
    private String cdNm;
    private YN delYn;
    private YN useYn;
}
