package com.example.apitemplate.domain.member;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final SqlSession sqlSession;
    private final String SQL_PREFIX = "com.example.apitemplate.domain.member.MemberMapper.";

//    public List<Post> findAllPost(){
//        return sqlSession.selectList(SQL_PREFIX+ "findAllMembers");
//    }
//    public Post findPostById(Long id){
//        return sqlSession.selectOne(SQL_PREFIX+ "findPostById", id);
//    }

    public void createMember(Member member){
        sqlSession.insert(SQL_PREFIX+ "createMember", member);
    }
}
