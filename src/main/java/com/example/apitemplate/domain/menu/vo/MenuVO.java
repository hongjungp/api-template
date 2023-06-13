package com.example.apitemplate.domain.menu.vo;

import com.example.apitemplate.domain.common.BaseVO;
import com.example.apitemplate.domain.common.YN;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MenuVO extends BaseVO {
    private String menuId;
    private String menuNm;
    private String menuUrl;
    private String prtMenuId;
    private int lvl;
    private YN leafYn;
}
