package com.example.apitemplate.post;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepository {
    private final SqlSession sqlSession;
    public List<Post> findAllPost(){
        return sqlSession.getMapper(PostMapper.class).findAllPosts();
    }
    public Post findPostById(Long id){
        return sqlSession.getMapper(PostMapper.class).findById(id);
    }

    public Long createPost(Post post){
        return sqlSession.getMapper(PostMapper.class).createPost(post);
    }
}
