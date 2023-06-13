//package com.example.apitemplate.domain.member;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpSession;
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/member")
//public class MemberController {
//    private final MemberService memberService;
//
//    @GetMapping
//    public String showMyPage(Model model, HttpSession httpSession){
//        Long id = (Long) httpSession.getAttribute("member_id");
//        Member member = memberService.findByIdMember(id);
//        model.addAttribute("member", member);
//        return "member/home";
//    }
//}
