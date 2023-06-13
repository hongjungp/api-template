package com.example.apitemplate.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseVO {
    protected String crtDt;
    protected String udtDt;
    protected String crtId;
    protected String udtId;
}
