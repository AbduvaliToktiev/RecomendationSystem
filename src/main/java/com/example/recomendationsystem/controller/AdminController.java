package com.example.recomendationsystem.controller;

import com.example.recomendationsystem.dto.AdminUserDto;
import com.example.recomendationsystem.entity.Product;
import com.example.recomendationsystem.entity.User;
import com.example.recomendationsystem.service.ProductService;
import com.example.recomendationsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping(value = "/api/v1/admin/")
public class AdminController {

    private final ProductService productService;
    private final UserService userService;

    @Autowired
    public AdminController(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping(value = "users/{id}")
    public ResponseEntity<AdminUserDto> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        AdminUserDto result = AdminUserDto.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "saveProduct")
    public String saveProduct(@RequestParam String productName,
                              @RequestParam String author,
                              @RequestParam String album,
                              @RequestParam MultipartFile image,
                              @RequestParam String genre,
                              @RequestParam Date yearOfIssue,
                              @RequestParam MultipartFile file
    ) throws IOException {
        Product product = new Product();

        product.setProductName(productName);
        product.setAuthor(author);
        product.setAlbum(album);
        product.setImage(image.getBytes());
        product.setGenre(genre);
        product.setYearOfIssue(yearOfIssue);
        product.setFile(file.getBytes());

        productService.save(product);
        return "SUCCESS";
    }
}
