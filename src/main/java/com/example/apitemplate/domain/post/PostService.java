package com.example.apitemplate.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    final private PostRepository postRepository;
    public CreatePostResponse createPost(CreatePostRequest createPostRequest){
        Post post = Post.builder()
                .title(createPostRequest.getTitle())
                .content(createPostRequest.getContent())
                .build();
        postRepository.createPost(post);
        System.out.println(post);
        Post newPost = findPostById(post.getId());
        CreatePostResponse createPostResponse = CreatePostResponse.builder()
                .title(newPost.getTitle())
                .content(newPost.getContent())
                .createdAt(newPost.getCreatedAt())
                .updatedAt(newPost.getUpdatedAt())
                .build();
        return createPostResponse;
    }
    public List<Post> findAllPosts(){
        return postRepository.findAllPost();
    }

    public Post findPostById(Long id){
        return postRepository.findPostById(id);
    }
}
