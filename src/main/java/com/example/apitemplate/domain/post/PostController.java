package com.example.apitemplate.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {
    final private PostService postService;

    @GetMapping
    public ResponseEntity<?> getPosts(){
        return ResponseEntity.ok(postService.findAllPosts());
    }

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody CreatePostRequest createPostRequest){
        CreatePostResponse createPostResponse = postService.createPost(createPostRequest);
        return ResponseEntity.created(URI.create("api/v1/posts")).body(createPostResponse);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<?> getPostById(@PathVariable Long postId){
        return ResponseEntity.ok(postService.findPostById(postId));
    }

}
