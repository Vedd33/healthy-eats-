package com.purehealthyeats.app.controller;

import com.purehealthyeats.app.model.Order;
import com.purehealthyeats.app.model.User;
import com.purehealthyeats.app.service.OrderService;
import com.purehealthyeats.app.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    private final OrderService orderService;
    private final CartService cartService;

    @Autowired
    public CheckoutController(OrderService orderService, CartService cartService) {
        this.orderService = orderService;
        this.cartService = cartService;
    }

    @GetMapping
    public String showCheckout(HttpSession session, Model model) {
        String sessionId = session.getId();
        
        // Check if cart is empty
        if (cartService.getCartItems(sessionId).isEmpty()) {
            return "redirect:/cart";
        }

        model.addAttribute("cartItems", cartService.getCartItems(sessionId));
        model.addAttribute("cartTotal", cartService.getCartTotal(sessionId));
        
        // Get user info if logged in
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            model.addAttribute("customerName", loggedInUser.getName());
            model.addAttribute("customerEmail", loggedInUser.getEmail());
        }
        
        return "checkout";
    }

    @PostMapping("/process")
    public String processCheckout(HttpSession session, 
                                @RequestParam String customerName,
                                @RequestParam String customerEmail,
                                RedirectAttributes redirectAttributes) {
        try {
            String sessionId = session.getId();
            Order order = orderService.createOrderFromCart(sessionId, customerName, customerEmail);
            
            redirectAttributes.addFlashAttribute("success", "Order placed successfully!");
            return "redirect:/bill/" + order.getId();
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/checkout";
        }
    }

}
