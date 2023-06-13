package com.example.apitemplate.domain.user.dao;

import com.example.apitemplate.domain.user.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final SqlSession sqlSession;
    private final String SQL_PREFIX = "com.example.apitemplate.domain.user.mapper.UserMapper.";
    public List<UserVO> findAllUsers(){
        return sqlSession.selectList(SQL_PREFIX+"findAllUsers");
    }

    public void insert(UserVO userVO) {
        sqlSession.insert(SQL_PREFIX+ "insertUser" ,userVO);
    }

    public void update(UserVO userVO) {
        sqlSession.update(SQL_PREFIX+"updateUser", userVO);
    }

    public void delete(UserVO userVO) {
        sqlSession.delete(SQL_PREFIX+"deleteUser", userVO);
    }

    public UserVO findByIdUser(String id) {
        return sqlSession.selectOne(SQL_PREFIX+"findById", id);
    }

    public void updateLoginInfo(String id){
        sqlSession.selectOne(SQL_PREFIX+"updateLoginInfo", id);
    }
}
