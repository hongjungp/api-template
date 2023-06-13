package com.example.apitemplate.domain.code.service;


import com.example.apitemplate.domain.code.dao.CodeDao;
import com.example.apitemplate.domain.code.dto.CodeDto;
import com.example.apitemplate.domain.code.mapper.CodeMapper;
import com.example.apitemplate.domain.code.vo.CodeVO;
import com.example.apitemplate.domain.common.WorkType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CodeService {
    private final CodeDao codeDao;

    public List<CodeVO> getCodes() {
        List<CodeVO> codes = codeDao.findAllCodes();
        return codes;
    }

    @Transactional
    public void setCodes(List<CodeDto> codes, String userId) {
        for (CodeDto dto : codes) {
            dto.setUdtId(userId);
            dto.setCrtId(userId);
            CodeVO codeVO = CodeMapper.toEntity(dto);
            switch (dto.getWrkTp()) {
                case C:
                    codeDao.insert(codeVO);
                    System.out.println(WorkType.C);
                    break;
                case U:
                    codeDao.update(codeVO);
                    System.out.println(WorkType.U);
                    break;
                case D:
                    codeDao.delete(codeVO);
                    System.out.println(WorkType.D);
                    break;
            }
        }
    }
}
