package com.purehealthyeats.app.controller;

import com.purehealthyeats.app.model.Order;
import com.purehealthyeats.app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class BillController {

    private final OrderService orderService;

    @Autowired
    public BillController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/bill/{orderId}")
    public String showBill(@PathVariable Long orderId, Model model) {
        Optional<Order> orderOpt = orderService.getOrderById(orderId);
        if (orderOpt.isPresent()) {
            Order order = orderOpt.get();
            model.addAttribute("order", order);
            return "bill";
        } else {
            return "redirect:/";
        }
    }
}
