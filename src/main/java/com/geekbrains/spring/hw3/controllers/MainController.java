package com.geekbrains.spring.hw3.controllers;

import com.geekbrains.spring.hw3.model.Product;
import com.geekbrains.spring.hw3.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/home")
public class MainController {

    private ProductService productService;

    @Autowired
    public MainController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public String showAllProducts(Model model) {
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);
        return "home";
    }

}
