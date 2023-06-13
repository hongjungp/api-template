package com.example.apitemplate.domain.menu.vo;

import com.example.apitemplate.domain.common.BaseVO;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
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
    private String leafYn;
}
