package com.example.apitemplate.domain.menu;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/new")
    public String showCreateMenuPage(){
        return "menu/new";
    }
    @PostMapping("/new")
    public String createMenu(@ModelAttribute CreateMenuRequest createMenuRequest, HttpSession httpSession){
        Long id = (Long) httpSession.getAttribute("member_id");
        createMenuRequest.setCrtId(id.toString());
        menuService.createMenu(createMenuRequest);
        return "redirect:/";
    }
    @GetMapping("/list")
    public String getMenuList(Model model){
        List<MenuResponse> menuList = menuService.getMenuList();
        model.addAttribute("menuList", menuList);
        return "menu/list";
    }
}
