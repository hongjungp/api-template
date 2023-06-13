package com.example.apitemplate.domain.menu.service;

import com.example.apitemplate.domain.common.WorkType;
import com.example.apitemplate.domain.menu.dao.MenuDao;
import com.example.apitemplate.domain.menu.dto.MenuDto;
import com.example.apitemplate.domain.menu.mapper.MenuMapper;
import com.example.apitemplate.domain.menu.vo.MenuVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuDao menuDao;

    public List<MenuVO> getMenus() {
        List<MenuVO> menus = menuDao.findAllMenus();
        return menus;
    }

    @Transactional
    public void setMenus(List<MenuDto> menus, String userId) {
        for (MenuDto dto : menus) {
            dto.setUdtId(userId);
            dto.setCrtId(userId);
            MenuVO menuVO = MenuMapper.toEntity(dto);
            switch (dto.getWrkTp()) {
                case C:
                    menuDao.insert(menuVO);
                    System.out.println(WorkType.C);
                    break;
                case U:
                    menuDao.update(menuVO);
                    System.out.println(WorkType.U);
                    break;
                case D:
                    menuDao.delete(menuVO);
                    System.out.println(WorkType.D);
                    break;
            }
        }
    }
}
