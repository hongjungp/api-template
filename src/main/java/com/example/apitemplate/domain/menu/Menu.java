package com.example.apitemplate.domain.menu;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Menu{
    private String menuId;
    private String menuNm;
    private String menuUrl;
    private String prtMenuId;
    private int lvl;
    private String leafYn;
    private LocalDateTime crtDt;
    private LocalDateTime udtDt;
    private String crtId;
    private String udtId;
}
