package com.example.apitemplate.domain.menu;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MenuResponse {
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
