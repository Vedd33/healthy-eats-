package com.purehealthyeats.app.controller;

import com.purehealthyeats.app.model.User;
import com.purehealthyeats.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {
        // Check if email already exists
        User existingUser = userService.findUserByEmail(user.getEmail());
        if (existingUser != null) {
            result.rejectValue("email", "error.user", "Email already exists. Please use a different email.");
        }
        
        if (result.hasErrors()) {
            return "register";
        }
        
        try {
            userService.registerUser(user);
            model.addAttribute("successMessage", "Registration successful! Please login.");
            return "redirect:/login?success";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "An error occurred during registration. Please try again.");
            return "register";
        }
    }
}

