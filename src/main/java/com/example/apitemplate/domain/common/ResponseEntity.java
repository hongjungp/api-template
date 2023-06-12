package com.example.apitemplate.domain.common;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class ResponseEntity<T> {
    private int seq;
    private T data;
    private Result result;
}
