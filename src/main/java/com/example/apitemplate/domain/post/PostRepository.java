package com.example.apitemplate.domain.post;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepository {
    private final SqlSession sqlSession;
    private final String SQL_PREFIX = "com.example.apitemplate.post.PostMapper.";

    public List<Post> findAllPost(){
        return sqlSession.selectList(SQL_PREFIX+ "findAllPosts");
    }
    public Post findPostById(Long id){
        return sqlSession.selectOne(SQL_PREFIX+ "findPostById", id);
    }

    public void createPost(Post post){
        sqlSession.insert(SQL_PREFIX+ "createPost", post);
    }
}
