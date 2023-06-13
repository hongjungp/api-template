package com.example.apitemplate.domain.user.controller;

import com.example.apitemplate.domain.common.*;
import com.example.apitemplate.domain.user.dto.UserDto;
import com.example.apitemplate.domain.user.service.UserService;
import com.example.apitemplate.domain.user.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;
    @PostMapping("/get-users")
    public ResponseEntity<?> getUsers(@RequestBody RequestEntity<Void> request, HttpSession httpSession){
        System.out.println(httpSession.getAttribute("usrId"));
        List<UserVO> users = userService.getUsers();
        ResponseEntity response =
                ResponseEntity.builder()
                .seq(request.getSeq())
                .data(users)
                .result(Result.builder()
                        .code(Status.SUCCESS.getCode())
                        .message(Status.SUCCESS.getMessage())
                        .build())
                .build();
        return response;
    }

    @PostMapping("/set-users")
    public ResponseEntity<?> setUsers(@RequestBody RequestEntity<UserDto> request, HttpSession httpSession){
        System.out.println(request.getData());
        System.out.println(httpSession.getAttribute("usrId"));
        String userId = (String) httpSession.getAttribute("usrId");
        userService.setUsers(request.getData(), userId);
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
