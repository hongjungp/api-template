package com.example.apitemplate.domain.menu.controller;

import com.example.apitemplate.domain.common.RequestEntity;
import com.example.apitemplate.domain.common.ResponseEntity;
import com.example.apitemplate.domain.common.Result;
import com.example.apitemplate.domain.common.Status;
import com.example.apitemplate.domain.menu.dto.MenuAuthDto;
import com.example.apitemplate.domain.menu.dto.MenuDto;
import com.example.apitemplate.domain.menu.service.MenuService;
import com.example.apitemplate.domain.menu.vo.MenuVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/menu")
public class MenuController {
    private final MenuService menuService;
    @PostMapping("/get-menus")
    public ResponseEntity<?> getMenus(@RequestBody RequestEntity<Void> request, HttpSession httpSession){
        String userId = (String) httpSession.getAttribute("usrId");
        List<MenuVO> menus = menuService.getMenus(userId);
        ResponseEntity response =
                ResponseEntity.builder()
                        .seq(request.getSeq())
                        .data(menus)
                        .result(Result.builder()
                                .code(Status.SUCCESS.getCode())
                                .message(Status.SUCCESS.getMessage())
                                .build())
                        .build();
        return response;
    }
    @PostMapping("/get-menus/all")
    public ResponseEntity<?> getMenusAll(@RequestBody RequestEntity<Void> request, HttpSession httpSession){
        List<MenuVO> menus = menuService.getMenusAll();
        ResponseEntity response =
                ResponseEntity.builder()
                        .seq(request.getSeq())
                        .data(menus)
                        .result(Result.builder()
                                .code(Status.SUCCESS.getCode())
                                .message(Status.SUCCESS.getMessage())
                                .build())
                        .build();
        return response;
    }

    @PostMapping("/set-menus")
    public ResponseEntity<?> setMenus(@RequestBody RequestEntity<MenuDto> request, HttpSession httpSession){
        String userId = (String) httpSession.getAttribute("usrId");
        menuService.setMenus(request.getData(), userId);
        ResponseEntity response =
                ResponseEntity.builder()
                        .result(Result.builder()
                                .code(Status.SUCCESS.getCode())
                                .message(Status.SUCCESS.getMessage())
                                .build())
                        .build();
        return response;
    }
    @PostMapping("/auth/set-auths")
    public ResponseEntity<?> setMenusAuth(@RequestBody RequestEntity<MenuAuthDto> request, HttpSession httpSession){
        String userId = (String) httpSession.getAttribute("usrId");
        menuService.setMenusAuth(request.getData(), userId);
        ResponseEntity response =
                ResponseEntity.builder()
                        .result(Result.builder()
                                .code(Status.SUCCESS.getCode())
                                .message(Status.SUCCESS.getMessage())
                                .build())
                        .build();
        return response;
    }
}
