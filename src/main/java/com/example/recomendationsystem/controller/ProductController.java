package com.example.recomendationsystem.controller;

import com.example.recomendationsystem.entity.Product;
import com.example.recomendationsystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users/")
public class ProductController {

    private final ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;

    }

    @GetMapping(value = "getProductByName")
    public List<Product> productByName(@RequestParam String productName) {
        return productService.search(productName);
    }

    @GetMapping(value = "getAllByAuthor")
    public List<Product> allAuthor(@RequestParam String author) {
        return productService.findByAuthor(author);
    }

    @GetMapping(value = "getAllByGenre")
    public List<Product> allGenre(@RequestParam String genre) {
        return productService.findByGenre(genre);
    }

    @GetMapping(value = "getAllByProductName")
    public List<Product> allProduct(@RequestParam String productName) {
        return productService.findAllByProductName(productName);
    }
}
