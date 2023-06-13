package com.example.apitemplate.domain.code.dao;

import com.example.apitemplate.domain.code.vo.CodeVO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CodeDao {
    private final SqlSession sqlSession;
    private final String SQL_PREFIX = "com.example.apitemplate.domain.code.mapper.CodeMapper.";
    public List<CodeVO> findAllCodes(){
        return sqlSession.selectList(SQL_PREFIX+"findAllCodes");
    }

    public void insert(CodeVO codeVO) {
        sqlSession.insert(SQL_PREFIX+ "insertCode" ,codeVO);
    }

    public void update(CodeVO codeVO) {
        sqlSession.update(SQL_PREFIX+"updateCode", codeVO);
    }

    public void delete(CodeVO codeVO) {
        sqlSession.delete(SQL_PREFIX+"deleteCode", codeVO);
    }

}
