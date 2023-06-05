package com.example.apitemplate.domain.post;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePostRequest {
    private Long id;
    private String title;
    private String content;
    private Long memberId;

}
