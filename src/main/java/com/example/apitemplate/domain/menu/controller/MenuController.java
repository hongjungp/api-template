package com.example.apitemplate.domain.menu.controller;

import com.example.apitemplate.domain.common.RequestEntity;
import com.example.apitemplate.domain.common.ResponseEntity;
import com.example.apitemplate.domain.common.Result;
import com.example.apitemplate.domain.common.Status;
import com.example.apitemplate.domain.menu.dto.MenuDto;
import com.example.apitemplate.domain.menu.service.MenuService;
import com.example.apitemplate.domain.menu.vo.MenuVO;
import com.example.apitemplate.domain.user.dto.UserDto;
import com.example.apitemplate.domain.user.service.UserService;
import com.example.apitemplate.domain.user.vo.UserVO;
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
    private final UserService userService;
    @PostMapping("/get-menus")
    public ResponseEntity<?> getMenus(@RequestBody RequestEntity<Void> request, HttpSession httpSession){
        List<MenuVO> menus = menuService.getUsers();
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

    @PostMapping("/set-users")
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
}
