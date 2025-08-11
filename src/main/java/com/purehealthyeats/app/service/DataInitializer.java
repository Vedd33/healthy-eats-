package com.purehealthyeats.app.service;

import com.purehealthyeats.app.model.MenuItem;
import com.purehealthyeats.app.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class DataInitializer {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Bean
    ApplicationRunner init() {
        return args -> {
            // Only initialize if database is empty
            if (menuItemRepository.count() == 0) {
                List<MenuItem> menuItems = Arrays.asList(
                    // SALADS
                    new MenuItem("Caesar Salad", "Fresh romaine lettuce, parmesan cheese, croutons, and caesar dressing", 
                                new BigDecimal("12.99"), MenuItem.ItemType.SALAD, "https://images.unsplash.com/photo-1551248429-40975aa4de74?w=400&h=300&fit=crop&crop=center"),
                    
                    new MenuItem("Greek Salad", "Mixed greens, feta cheese, olives, tomatoes, cucumber, and olive oil dressing", 
                                new BigDecimal("11.49"), MenuItem.ItemType.SALAD, "https://images.unsplash.com/photo-1540420773420-3366772f4999?w=400&h=300&fit=crop&crop=center"),
                    
                    new MenuItem("Quinoa Power Bowl", "Quinoa, mixed vegetables, avocado, chickpeas, and tahini dressing", 
                                new BigDecimal("13.99"), MenuItem.ItemType.SALAD, "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?w=400&h=300&fit=crop&crop=center"),
                    
                    new MenuItem("Kale & Spinach Salad", "Fresh kale, spinach, cranberries, walnuts, and balsamic vinaigrette", 
                                new BigDecimal("10.99"), MenuItem.ItemType.SALAD, "https://images.unsplash.com/photo-1515543237350-b3eea1ec8082?w=400&h=300&fit=crop&crop=center"),
                    
                    new MenuItem("Asian Chicken Salad", "Grilled chicken, mixed greens, mandarin oranges, almonds, and sesame dressing", 
                                new BigDecimal("14.49"), MenuItem.ItemType.SALAD, "https://images.unsplash.com/photo-1559847844-d72fcfe73267?w=400&h=300&fit=crop&crop=center"),
                    
                    new MenuItem("Mediterranean Bowl", "Mixed greens, hummus, tabbouleh, olives, and grilled chicken", 
                                new BigDecimal("15.99"), MenuItem.ItemType.SALAD, "https://images.unsplash.com/photo-1546793665-c74683f339c1?w=400&h=300&fit=crop&crop=center"),
                    
                    // JUICES
                    new MenuItem("Green Detox Juice", "Spinach, kale, cucumber, apple, lemon, and ginger", 
                                new BigDecimal("6.99"), MenuItem.ItemType.JUICE, "https://images.unsplash.com/photo-1610970881699-44a5587cabec?w=400&h=300&fit=crop&crop=center"),
                    
                    new MenuItem("Orange Carrot Ginger", "Fresh orange, carrot, and ginger blend for immune boost", 
                                new BigDecimal("5.49"), MenuItem.ItemType.JUICE, "https://images.unsplash.com/photo-1622597467836-f3285f2131b8?w=400&h=300&fit=crop&crop=center"),
                    
                    new MenuItem("Berry Antioxidant Blast", "Blueberries, strawberries, raspberries, and pomegranate", 
                                new BigDecimal("7.99"), MenuItem.ItemType.JUICE, "https://images.unsplash.com/photo-1553530666-ba11a7da3888?w=400&h=300&fit=crop&crop=center"),
                    
                    new MenuItem("Tropical Paradise", "Pineapple, mango, coconut water, and mint", 
                                new BigDecimal("6.49"), MenuItem.ItemType.JUICE, "https://images.unsplash.com/photo-1559181567-c3190ca9959b?w=400&h=300&fit=crop&crop=center"),
                    
                    new MenuItem("Beet Energy Boost", "Beetroot, apple, carrot, and lemon for natural energy", 
                                new BigDecimal("6.99"), MenuItem.ItemType.JUICE, "https://images.unsplash.com/photo-1571680432462-52f8b132beaa?w=400&h=300&fit=crop&crop=center"),
                    
                    new MenuItem("Celery Cleanse", "Celery, cucumber, apple, and lime for natural cleansing", 
                                new BigDecimal("5.99"), MenuItem.ItemType.JUICE, "https://images.unsplash.com/photo-1622543925917-763c34d1a86e?w=400&h=300&fit=crop&crop=center")
                );
                
                menuItemRepository.saveAll(menuItems);
                System.out.println("Sample menu items initialized successfully!");
            }
        };
    }
}
