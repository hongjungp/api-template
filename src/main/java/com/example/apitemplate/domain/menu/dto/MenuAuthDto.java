package com.example.apitemplate.domain.menu.dto;

import com.example.apitemplate.domain.common.BaseDto;
import com.example.apitemplate.domain.common.YN;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MenuAuthDto extends BaseDto {
    private String menuId;
    private String authId;
}
