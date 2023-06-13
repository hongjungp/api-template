package com.example.apitemplate.domain.auth.dao;

import com.example.apitemplate.domain.auth.vo.AuthVO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AuthDao {
    private final SqlSession sqlSession;
    private final String SQL_PREFIX = "com.example.apitemplate.domain.auth.mapper.AuthMapper.";

    public List<AuthVO> findAllAuths() {
        return sqlSession.selectList(SQL_PREFIX + "findAllAuths");
    }

    public void insert(AuthVO authVO) {
        sqlSession.insert(SQL_PREFIX + "insertAuth", authVO);
    }

    public void update(AuthVO authVO) {
        sqlSession.update(SQL_PREFIX + "updateAuth", authVO);
    }

    public void delete(AuthVO authVO) {
        sqlSession.delete(SQL_PREFIX + "deleteAuth", authVO);
    }

}
