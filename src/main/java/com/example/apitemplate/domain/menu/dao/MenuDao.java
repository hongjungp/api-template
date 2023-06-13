package com.example.apitemplate.domain.menu.dao;

import com.example.apitemplate.domain.menu.vo.MenuAuthVO;
import com.example.apitemplate.domain.menu.vo.MenuVO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MenuDao {
    private final SqlSession sqlSession;
    private final String SQL_PREFIX = "com.example.apitemplate.domain.menu.mapper.MenuMapper.";

    public List<MenuVO> findAllMenus() {
        return sqlSession.selectList(SQL_PREFIX + "findAllMenus");
    }
    public List<MenuVO> findAllMenusAuth(String usrId) {
        return sqlSession.selectList(SQL_PREFIX + "findAllMenusWithAuth", usrId);
    }

    public void insert(MenuVO menuVO) {
        sqlSession.insert(SQL_PREFIX + "insertMenu", menuVO);
    }

    public void update(MenuVO menuVO) {
        sqlSession.update(SQL_PREFIX + "updateMenu", menuVO);
    }

    public void delete(MenuVO menuVO) {
        sqlSession.delete(SQL_PREFIX + "deleteMenu", menuVO);
    }

    public void insertMenuAuth(MenuAuthVO menuAuthVO) {
        sqlSession.insert(SQL_PREFIX + "insertMenuAuth", menuAuthVO);
    }
    public void deleteMenuAuth(MenuAuthVO menuAuthVO) {
        sqlSession.delete(SQL_PREFIX + "deleteMenuAuth", menuAuthVO);
    }
}
