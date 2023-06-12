package com.example.apitemplate.domain.menu;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateMenuRequest{
    private String menuNm;
    private String menuUrl;
    private String prtMenuId;
//    private int lvl;
//    private String leafYn;s
//    private LocalDateTime crtDt;
    private String crtId;
//    private String udtId;
}
