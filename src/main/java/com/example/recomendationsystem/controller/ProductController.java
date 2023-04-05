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
//
//    @PostMapping(value = "saveProduct")
//    public String saveProduct(@RequestParam String productName,
//                              @RequestParam String author,
//                              @RequestParam String album,
//                              @RequestParam MultipartFile image,
//                              @RequestParam String genre,
//                              @RequestParam Date yearOfIssue,
//                              @RequestParam MultipartFile file
//    ) throws IOException {
//        Product product = new Product();
//
//        product.setProductName(productName);
//        product.setAuthor(author);
//        product.setAlbum(album);
//        product.setImage(image.getBytes());
//        product.setGenre(genre);
//        product.setYearOfIssue(yearOfIssue);
//        product.setFile(file.getBytes());
//
//        productService.save(product);
//        return "SUCCESS";
//    }

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
