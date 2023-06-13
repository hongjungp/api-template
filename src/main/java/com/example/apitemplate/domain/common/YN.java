package com.example.apitemplate.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum YN {
    Y("Y"),
    N("N");
    private final String code;
}
