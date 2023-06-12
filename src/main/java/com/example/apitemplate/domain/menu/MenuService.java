package com.example.apitemplate.domain.menu;

import com.example.apitemplate.domain.member.Member;
import com.example.apitemplate.domain.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;
    private final MemberService memberService;
    @Transactional
    public MenuResponse createMenu(CreateMenuRequest createMenuRequest) {
        LocalDateTime now = LocalDateTime.now();
        Optional<Menu> parentMenu = menuRepository.findByIdMenu(createMenuRequest.getPrtMenuId());
        Menu menu = Menu.builder()
                .menuId(UUID.randomUUID().toString())
                .menuNm(createMenuRequest.getMenuNm())
                .menuUrl(createMenuRequest.getMenuUrl())
                .prtMenuId(createMenuRequest.getPrtMenuId())
                .lvl(parentMenu.map(Menu::getLvl).orElse(0)+1)
                .leafYn("Y")
                .crtDt(now)
                .udtDt(now)
                .crtId(createMenuRequest.getCrtId())
                .udtId(createMenuRequest.getCrtId())
                .build();
        System.out.println(menu);
        menuRepository.createMenu(menu);
//        parentMenu.isPresent((a)->  );
        return getMenuById(menu.getMenuId());
    }

    public MenuResponse getMenuById(String id) {
        Menu menu = menuRepository.findByIdMenu(id).orElseThrow();
        MenuResponse menuResponse = MenuResponse.builder()
                .menuId(menu.getMenuId())
                .menuNm(menu.getMenuNm())
                .menuUrl(menu.getMenuUrl())
                .prtMenuId(menu.getPrtMenuId())
                .lvl(menu.getLvl())
                .leafYn(menu.getLeafYn())
                .crtDt(menu.getCrtDt())
                .udtDt(menu.getUdtDt())
                .crtId(menu.getCrtId())
                .udtId(menu.getUdtId())
                .build();
        return menuResponse;
    }

    public MenuResponse toResponse(Menu menu) {
        return MenuResponse.builder()
                .menuId(menu.getMenuId())
                .menuNm(menu.getMenuNm())
                .menuUrl(menu.getMenuUrl())
                .prtMenuId(menu.getPrtMenuId())
                .lvl(menu.getLvl())
                .leafYn(menu.getLeafYn())
                .crtDt(menu.getCrtDt())
                .udtDt(menu.getUdtDt())
                .crtId(menu.getCrtId())
                .udtId(menu.getCrtId())
                .build();
    }

    public List<MenuResponse> getMenuList() {
        List<Menu> menuList = menuRepository.findAllMenu();
        System.out.println(menuList);
        return menuList.stream().map(menu -> toResponse(menu)).collect(Collectors.toList());
    }
}
