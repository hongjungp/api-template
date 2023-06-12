package com.example.apitemplate.domain.menu;

import com.example.apitemplate.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MenuRepository {
    private final SqlSession sqlSession;
    private final String SQL_PREFIX = "com.example.apitemplate.domain.menu.MenuMapper.";

    public void createMenu(Menu menu) {
        sqlSession.insert(SQL_PREFIX + "createMenu", menu);
    }

    public Optional<Menu> findByIdMenu(String id) {
        return sqlSession.selectOne(SQL_PREFIX + "findMenuById", id);
    }

    public List<Menu> findAllMenu() {
        return sqlSession.selectList(SQL_PREFIX + "findAllMenuList");
    }

    public void updateMenu(Menu menu) {
        sqlSession.update(SQL_PREFIX + "updateMenu", menu);
    }
}
