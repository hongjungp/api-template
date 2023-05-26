package com.example.apitemplate.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    final private PostRepository postRepository;
    public Post createPost(CreatePostRequest createPostRequest){
        Post post = Post.builder()
                .title(createPostRequest.getTitle())
                .content(createPostRequest.getContent())
                .build();
        Long id = postRepository.createPost(post);
        return findPostById(id);
    }
    public List<Post> findAllPosts(){
        return postRepository.findAllPost();
    }

    public Post findPostById(Long id){
        return postRepository.findPostById(id);
    }
}
