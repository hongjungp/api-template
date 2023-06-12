package com.example.apitemplate.domain.user.controller;

import com.example.apitemplate.domain.common.RequestEntity;
import com.example.apitemplate.domain.common.ResponseEntity;
import com.example.apitemplate.domain.common.Result;
import com.example.apitemplate.domain.common.Status;
import com.example.apitemplate.domain.user.dto.UserDto;
import com.example.apitemplate.domain.user.service.UserService;
import com.example.apitemplate.domain.user.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;
    @PostMapping("/get-users")
    public ResponseEntity<UserVO> getUsers(@RequestBody RequestEntity request){
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
    public ResponseEntity<UserVO> setUsers(@RequestBody RequestEntity<UserDto> request){
        userService.setUsers(request.getData());
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
