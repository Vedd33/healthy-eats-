package com.purehealthyeats.app.controller;

import com.purehealthyeats.app.model.CartItem;
import com.purehealthyeats.app.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public String viewCart(HttpSession session, Model model) {
        String sessionId = session.getId();
        List<CartItem> cartItems = cartService.getCartItems(sessionId);
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("cartTotal", cartService.getCartTotal(sessionId));
        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(HttpSession session, @RequestParam Long menuItemId, 
                            @RequestParam(defaultValue = "1") int quantity, 
                            @RequestParam String customizations, 
                            RedirectAttributes redirectAttributes) {
        String sessionId = session.getId();
        try {
            cartService.addToCart(sessionId, menuItemId, quantity, customizations);
            redirectAttributes.addFlashAttribute("success", "Item added to cart");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/menu";
    }

    @PostMapping("/update")
    public String updateCartItem(@RequestParam Long cartItemId, @RequestParam int quantity, 
                                 RedirectAttributes redirectAttributes) {
        cartService.updateQuantity(cartItemId, quantity);
        redirectAttributes.addFlashAttribute("success", "Cart updated successfully");
        return "redirect:/cart";
    }

    @PostMapping("/remove")
    public String removeFromCart(@RequestParam Long cartItemId, RedirectAttributes redirectAttributes) {
        cartService.removeFromCart(cartItemId);
        redirectAttributes.addFlashAttribute("success", "Item removed from cart");
        return "redirect:/cart";
    }

    @PostMapping("/clear")
    public String clearCart(HttpSession session, RedirectAttributes redirectAttributes) {
        String sessionId = session.getId();
        cartService.clearCart(sessionId);
        redirectAttributes.addFlashAttribute("success", "Cart cleared successfully");
        return "redirect:/cart";
    }
}
