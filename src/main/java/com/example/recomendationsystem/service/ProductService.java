package com.example.recomendationsystem.service;

import com.example.recomendationsystem.entity.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

   List<Product> search(String productName);

    List<Product> findByAuthor(String author);

    List<Product> findByGenre(String genre);

    List<Product> findAllByProductName(String productName);
}
