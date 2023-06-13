//package com.example.apitemplate.domain.member;
//
//import lombok.RequiredArgsConstructor;
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//@RequiredArgsConstructor
//public class MemberRepository {
//    private final SqlSession sqlSession;
//    private final String SQL_PREFIX = "com.example.apitemplate.domain.member.MemberMapper.";
//
//    public void createMember(Member member){
//        sqlSession.insert(SQL_PREFIX+ "createMember", member);
//    }
//    public Member findByIdMember(Long id){
//        return sqlSession.selectOne(SQL_PREFIX+ "findByIdMember", id);
//    }
//    public Member findByEmailMember(String email){
//        return sqlSession.selectOne(SQL_PREFIX+ "findByEmailMember", email);
//    }
//}
