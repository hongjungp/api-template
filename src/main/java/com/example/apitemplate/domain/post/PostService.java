//package com.example.apitemplate.domain.post;
//
//import com.example.apitemplate.domain.member.Member;
//import com.example.apitemplate.domain.member.MemberService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.HttpSession;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class PostService {
//    final private PostRepository postRepository;
//    final private MemberService memberService;
//
//    public PostResponse createPost(CreatePostRequest createPostRequest) {
//        Member member = memberService.findByIdMember(createPostRequest.getMemberId());
//        Post post = Post.builder()
//                .title(createPostRequest.getTitle())
//                .content(createPostRequest.getContent())
//                .memberId(member.getId())
//                .build();
//        postRepository.createPost(post);
//        return getPostById(post.getId());
//    }
//
//    public List<PostResponse> findAllPosts() {
//        List<Post> posts = postRepository.findAllPost();
//        return posts.stream().map(post -> toResponse(post)
//        ).collect(Collectors.toList());
//    }
//
//    public PostResponse getPostById(Long id) {
//        return toResponse(postRepository.findPostById(id));
//    }
//
//    public PostResponse toResponse(Post post) {
//        return PostResponse.builder()
//                .id(post.getId())
//                .title(post.getTitle())
//                .content(post.getContent())
//                .createdAt(post.getCreatedAt())
//                .updatedAt(post.getUpdatedAt())
//                .memberId(post.getMemberId())
//                .author(memberService.findByIdMember(post.getMemberId()).getNickname())
//                .build();
//    }
//
//    public PostResponse updatePost(UpdatePostRequest updatePostRequest) {
//        Post post = Post.builder()
//                .id(updatePostRequest.getId())
//                .title(updatePostRequest.getTitle())
//                .content(updatePostRequest.getContent())
//                .memberId(updatePostRequest.getMemberId())
//                .build();
//        postRepository.updatePost(post);
//        return getPostById(post.getId());
//    }
//
//    public void deletePost(Long id) {
//        postRepository.deletePost(id);
//    }
//
//}
