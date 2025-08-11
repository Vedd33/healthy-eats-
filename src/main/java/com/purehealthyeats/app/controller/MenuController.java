package com.purehealthyeats.app.controller;

import com.purehealthyeats.app.model.MenuItem;
import com.purehealthyeats.app.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public String showMenu(Model model, @RequestParam(required = false) String type) {
        List<MenuItem> items;
        
        if ("salads".equals(type)) {
            items = menuService.getItemsByType(MenuItem.ItemType.SALAD);
            model.addAttribute("pageTitle", "Our Fresh Salads");
        } else if ("juices".equals(type)) {
            items = menuService.getItemsByType(MenuItem.ItemType.JUICE);
            model.addAttribute("pageTitle", "Our Fresh Juices");
        } else {
            items = menuService.getAllAvailableItems();
            model.addAttribute("pageTitle", "Our Complete Menu");
        }
        
        model.addAttribute("menuItems", items);
        model.addAttribute("currentType", type);
        return "menu";
    }

    @GetMapping("/customize/{id}")
    public String customizeItem(@PathVariable Long id, Model model) {
        Optional<MenuItem> itemOpt = menuService.getItemById(id);
        if (itemOpt.isPresent()) {
            model.addAttribute("menuItem", itemOpt.get());
            return "customize";
        }
        return "redirect:/menu";
    }
}
