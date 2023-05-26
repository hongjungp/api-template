package com.example.apitemplate.post;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
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
        return ResponseEntity.ok(postService.createPost(createPostRequest));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<?> getPostById(@PathVariable Long postId){
        return ResponseEntity.ok(postService.findPostById(postId));
    }

}
