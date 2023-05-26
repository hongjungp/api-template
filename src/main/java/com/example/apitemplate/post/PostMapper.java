package com.example.apitemplate.post;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {
    @Select("SELECT * FROM posts")
    List<Post> findAllPosts();
    @Insert("INSERT INTO posts (title, content) VALUES( #{title}, #{content})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Long createPost(Post post);
    @Select("SELECT * FROM posts WHERE id=#{id}")
    Post findById(@Param("id") Long id);
}
