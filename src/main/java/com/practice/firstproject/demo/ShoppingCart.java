package com.practice.firstproject.demo;

import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
public class ShoppingCart {
    public void checkout(String status) {
        System.out.println("Checkout Method from ShoppingCart Called");
    }
    
    public String getCartStatus() {
        System.out.println("Getting cart status...");
        return "READY";
    }
    
    public double getCartTotal() {
        System.out.println("Calculating cart total...");
        return 99.99;
    }
    
    public List<String> getItems() {
        System.out.println("Retrieving items from cart...");
        return Arrays.asList("Item1", "Item2", "Item3");
    }
    
    public boolean isEmpty() {
        System.out.println("Checking if cart is empty...");
        return false;
    }
}