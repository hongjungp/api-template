package com.example.apitemplate.domain.code.controller;

import com.example.apitemplate.domain.code.dto.CodeDto;
import com.example.apitemplate.domain.code.service.CodeService;
import com.example.apitemplate.domain.code.vo.CodeVO;
import com.example.apitemplate.domain.common.RequestEntity;
import com.example.apitemplate.domain.common.ResponseEntity;
import com.example.apitemplate.domain.common.Result;
import com.example.apitemplate.domain.common.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/code")
public class CodeController {
    private final CodeService codeService;
    @PostMapping("/get-codes")
    public ResponseEntity<?> getCodes(@RequestBody RequestEntity<Void> request, HttpSession httpSession){
        List<CodeVO> codes = codeService.getCodes();
        ResponseEntity response =
                ResponseEntity.builder()
                        .seq(request.getSeq())
                        .data(codes)
                        .result(Result.builder()
                                .code(Status.SUCCESS.getCode())
                                .message(Status.SUCCESS.getMessage())
                                .build())
                        .build();
        return response;
    }

    @PostMapping("/set-codes")
    public ResponseEntity<?> setCodes(@RequestBody RequestEntity<CodeDto> request, HttpSession httpSession){
        String userId = (String) httpSession.getAttribute("usrId");
        codeService.setCodes(request.getData(), userId);
        ResponseEntity response =
                ResponseEntity.builder()
                        .result(Result.builder()
                                .code(Status.SUCCESS.getCode())
                                .message(Status.SUCCESS.getMessage())
                                .build())
                        .build();
        return response;
    }
}
