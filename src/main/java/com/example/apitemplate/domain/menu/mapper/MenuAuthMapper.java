package com.example.apitemplate.domain.menu.mapper;

import com.example.apitemplate.domain.menu.dto.MenuAuthDto;
import com.example.apitemplate.domain.menu.dto.MenuDto;
import com.example.apitemplate.domain.menu.vo.MenuAuthVO;
import com.example.apitemplate.domain.menu.vo.MenuVO;

public class MenuAuthMapper {
    public static MenuAuthVO toEntity(MenuAuthDto menuAuthDto){
        return MenuAuthVO.builder()
                .menuId(menuAuthDto.getMenuId())
                .authId(menuAuthDto.getAuthId())
                .crtDt(menuAuthDto.getCrtDt())
                .udtDt(menuAuthDto.getUdtDt())
                .crtId(menuAuthDto.getCrtId())
                .udtId(menuAuthDto.getUdtId())
                .build();
    }
}
