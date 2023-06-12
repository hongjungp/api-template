package com.example.apitemplate.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WorkType {
    C("C"),
    U("U"),
    D("D");
    private final String code;
}
