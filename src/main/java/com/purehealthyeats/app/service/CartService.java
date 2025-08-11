package com.purehealthyeats.app.service;

import com.purehealthyeats.app.model.CartItem;
import com.purehealthyeats.app.model.MenuItem;
import com.purehealthyeats.app.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private final CartItemRepository cartItemRepository;
    private final MenuService menuService;

    @Autowired
    public CartService(CartItemRepository cartItemRepository, MenuService menuService) {
        this.cartItemRepository = cartItemRepository;
        this.menuService = menuService;
    }

    public List<CartItem> getCartItems(String sessionId) {
        return cartItemRepository.findBySessionId(sessionId);
    }

    public CartItem addToCart(String sessionId, Long menuItemId, int quantity, String customizations) {
        Optional<MenuItem> menuItemOpt = menuService.getItemById(menuItemId);
        if (menuItemOpt.isPresent()) {
            CartItem cartItem = new CartItem(sessionId, menuItemOpt.get(), quantity, customizations);
            return cartItemRepository.save(cartItem);
        }
        throw new RuntimeException("Menu item not found");
    }

    public void updateQuantity(Long cartItemId, int quantity) {
        Optional<CartItem> cartItemOpt = cartItemRepository.findById(cartItemId);
        if (cartItemOpt.isPresent()) {
            CartItem cartItem = cartItemOpt.get();
            cartItem.setQuantity(quantity);
            cartItemRepository.save(cartItem);
        }
    }

    public void removeFromCart(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    @Transactional
    public void clearCart(String sessionId) {
        cartItemRepository.deleteBySessionId(sessionId);
    }

    public BigDecimal getCartTotal(String sessionId) {
        List<CartItem> cartItems = getCartItems(sessionId);
        return cartItems.stream()
                .map(CartItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public int getCartItemCount(String sessionId) {
        List<CartItem> cartItems = getCartItems(sessionId);
        return cartItems.stream()
                .mapToInt(CartItem::getQuantity)
                .sum();
    }
}
