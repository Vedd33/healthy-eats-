package com.purehealthyeats.app.service;

import com.purehealthyeats.app.model.*;
import com.purehealthyeats.app.repository.OrderRepository;
import com.purehealthyeats.app.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CartService cartService;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository, CartService cartService) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.cartService = cartService;
    }

    @Transactional
    public Order createOrderFromCart(String sessionId, String customerName, String customerEmail) {
        List<CartItem> cartItems = cartService.getCartItems(sessionId);
        
        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        BigDecimal totalAmount = cartService.getCartTotal(sessionId);
        Order order = new Order(customerName, customerEmail, totalAmount);
        order = orderRepository.save(order);

        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = new OrderItem(
                order,
                cartItem.getMenuItem(),
                cartItem.getQuantity(),
                cartItem.getCustomizations(),
                cartItem.getMenuItem().getPrice()
            );
            orderItems.add(orderItem);
        }

        orderItemRepository.saveAll(orderItems);
        order.setOrderItems(orderItems);

        // Clear the cart after successful order
        cartService.clearCart(sessionId);

        return order;
    }

    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
