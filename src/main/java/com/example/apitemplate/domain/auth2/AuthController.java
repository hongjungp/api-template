//package com.example.apitemplate.domain.auth2;
//
//import com.example.apitemplate.domain.member.CreateMemberRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpSession;
//
//@Controller
//@RequestMapping("/auth2")
//@RequiredArgsConstructor
//public class AuthController {
//    private final AuthService authService;
//    @GetMapping("/login")
//    public String showLoginPage(){
//        return "/auth/login";
//    }
//    @GetMapping("/signup")
//    public String showSignupPage(){
//        return "/auth/signup";
//    }
//
//    @PostMapping("/login")
//    public String login(@ModelAttribute LoginRequest loginRequest, HttpSession httpSession){
//        Long memberId = authService.login(loginRequest);
//        if(memberId == null){
//            return "redirect:/auth/login";
//        }
//        httpSession.setAttribute("member_id", memberId);
//        System.out.println(httpSession.getAttribute("member_id"));
//        return "redirect:/";
//    }
//    @PostMapping("/signup")
//    public String signup(@ModelAttribute CreateMemberRequest createMemberRequest){
//        System.out.println(createMemberRequest);
//        authService.signup(createMemberRequest);
//        return "redirect:/auth/login";
//    }
//
//}
