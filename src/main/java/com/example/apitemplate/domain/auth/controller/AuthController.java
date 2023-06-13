package com.example.apitemplate.domain.auth.controller;

import com.example.apitemplate.domain.auth.dto.LoginDto;
import com.example.apitemplate.domain.auth.service.AuthService;
import com.example.apitemplate.domain.common.ResponseEntity;
import com.example.apitemplate.domain.common.Result;
import com.example.apitemplate.domain.common.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto, HttpSession httpSession){
        String usrId = authService.login(loginDto);
        httpSession.setAttribute("usrId", usrId);
        ResponseEntity response = ResponseEntity.builder()
                .result(Result.builder()
                        .code(Status.SUCCESS.getCode())
                        .message(Status.SUCCESS.getMessage())
                        .build())
                .build();
        System.out.println(httpSession.getAttribute("usrId"));
        return response;
    }
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession httpSession){
        httpSession.invalidate();
        ResponseEntity response = ResponseEntity.builder()
                .result(Result.builder()
                        .code(Status.SUCCESS.getCode())
                        .message(Status.SUCCESS.getMessage())
                        .build())
                .build();
        return response;
    }
}
