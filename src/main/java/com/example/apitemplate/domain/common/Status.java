package com.example.apitemplate.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
    SUCCESS("00", "Success!"),
    PARAMETER_ERROR("01", "Bad Request Error!"),
    NOT_FOUND_DATA("02", "Not found Error!");

    private String code;
    private String message;

}
