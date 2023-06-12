package com.example.apitemplate.domain.user;

import com.example.apitemplate.domain.common.ResponseEntity;
import com.example.apitemplate.domain.common.Result;
import com.example.apitemplate.domain.common.Status;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;


class UserControllerTest {
    @Test
    void getUsers() {
        Result result = Result.builder()
                .code(Status.SUCCESS.getCode())
                .message(Status.SUCCESS.getMessage())
                .build();
        ResponseEntity response = ResponseEntity.builder()
                .seq(12)
                .result(result)
                .build();
        System.out.println(Status.SUCCESS.getMessage());
        System.out.println(Status.SUCCESS.getCode());
    }

}