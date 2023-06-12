package com.example.apitemplate.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    @GetMapping("/new")
    public String showCreatePostPage() {
        return "post/new";
    }



    @PostMapping("/new")
    public String createPost(@ModelAttribute CreatePostRequest createPostRequest, HttpSession httpSession) {
        Long id = (Long) httpSession.getAttribute("member_id");
        createPostRequest.setMemberId(id);
        postService.createPost(createPostRequest);
        return "redirect:/posts";
    }

    @GetMapping
    public String showPostListPage(Model model) {
        List<PostResponse> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);
        return "post/list";
    }

    @GetMapping("/{postId}")
    public String showPostListPage(@PathVariable Long postId, Model model) {
        PostResponse post = postService.getPostById(postId);
        model.addAttribute("post", post);
        return "post/detail";
    }

    @GetMapping("/{postId}/edit")
    public String showEditPostPage(@PathVariable Long postId, Model model) {
        PostResponse post = postService.getPostById(postId);
        model.addAttribute("post", post);
        return "post/edit";
    }
    @PostMapping("/{postId}/edit")
    public String updatePost(@PathVariable Long postId, HttpSession httpSession, UpdatePostRequest updatePostRequest) {
        updatePostRequest.setId(postId);
        postService.updatePost(updatePostRequest);
        return "redirect:/posts/"+ postId;
    }
    @PostMapping("/{postId}/delete")
    public String updatePost(@PathVariable Long postId, HttpSession httpSession) {
        postService.deletePost(postId);
        return "redirect:/posts";
    }

}
