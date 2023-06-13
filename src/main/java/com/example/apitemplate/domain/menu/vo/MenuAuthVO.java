package com.example.apitemplate.domain.menu.vo;

import com.example.apitemplate.domain.common.BaseVO;
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
public class MenuAuthVO extends BaseVO {
    private String menuId;
    private String authId;
}
