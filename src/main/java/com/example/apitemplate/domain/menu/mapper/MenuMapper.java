package com.example.apitemplate.domain.menu.mapper;

import com.example.apitemplate.domain.common.WorkType;
import com.example.apitemplate.domain.menu.dto.MenuDto;
import com.example.apitemplate.domain.menu.vo.MenuVO;

public class MenuMapper {
    public static MenuVO toEntity(MenuDto menuDto){
        return MenuVO.builder()
                .menuId(menuDto.getMenuId())
                .menuNm(menuDto.getMenuNm())
                .menuUrl(menuDto.getMenuUrl())
                .prtMenuId(menuDto.getPrtMenuId())
                .lvl(menuDto.getLvl())
                .leafYn(menuDto.getLeafYn())
                .crtDt(menuDto.getCrtDt())
                .udtDt(menuDto.getUdtDt())
                .crtId(menuDto.getCrtId())
                .udtId(menuDto.getUdtId())
                .build();
    }
}
