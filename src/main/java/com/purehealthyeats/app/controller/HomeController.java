package com.purehealthyeats.app.controller;

import com.purehealthyeats.app.model.MenuItem;
import com.purehealthyeats.app.service.MenuService;
import com.purehealthyeats.app.service.UserService;
import com.purehealthyeats.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    private final MenuService menuService;
    private final UserService userService;

    @Autowired
    public HomeController(MenuService menuService, UserService userService) {
        this.menuService = menuService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model) {
        // Add company description and featured items
        model.addAttribute("companyName", "Pure Healthy Eats");
        model.addAttribute("companyDescription", 
            "Welcome to Pure Healthy Eats - your destination for fresh, nutritious salads and refreshing juices. " +
            "We believe in providing wholesome meals that nourish your body and delight your taste buds.");
        
        // Get featured items
        List<MenuItem> featuredSalads = menuService.getItemsByType(MenuItem.ItemType.SALAD);
        List<MenuItem> featuredJuices = menuService.getItemsByType(MenuItem.ItemType.JUICE);
        
        model.addAttribute("featuredSalads", featuredSalads.size() > 3 ? featuredSalads.subList(0, 3) : featuredSalads);
        model.addAttribute("featuredJuices", featuredJuices.size() > 3 ? featuredJuices.subList(0, 3) : featuredJuices);
        
        return "home";
    }
    
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, 
                       HttpSession session, RedirectAttributes redirectAttributes) {
        User user = userService.findUserByEmail(email);
        
        if (user != null && password.equals(user.getPassword())) {
            session.setAttribute("loggedInUser", user);
            session.setAttribute("userName", user.getName());
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid email or password");
            return "redirect:/login";
        }
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
