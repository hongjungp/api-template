package com.example.apitemplate.domain.menu.dto;

import com.example.apitemplate.domain.common.BaseDto;
import com.example.apitemplate.domain.common.WorkType;
import com.example.apitemplate.domain.common.YN;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MenuDto extends BaseDto {
    private String menuId;
    private String menuNm;
    private String menuUrl;
    private String prtMenuId;
    private int lvl;
    private YN leafYn;
}
