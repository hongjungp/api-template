package com.example.apitemplate.domain.common;

import lombok.*;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RequestEntity<T> {
    private int seq;
    private List<T> data;
}
