package com.example.recomendationsystem.service.impl;

import com.example.recomendationsystem.entity.Product;
import com.example.recomendationsystem.repository.ProductRepository;
import com.example.recomendationsystem.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        productRepository.save(product);
        return product;
    }

    @Transactional
    @Override
    public List<Product> search(String productName) {
       List<Product> products = productRepository.findByProductName(productName);
        return products;
    }

    @Transactional
    @Override
    public List<Product> findByAuthor(String author) {
        List<Product> products = productRepository.findByAuthor(author);
        return products;
    }

    @Transactional
    @Override
    public List<Product> findByGenre(String genre) {
        List<Product> products = productRepository.findByGenre(genre);
        return products;
    }

    @Transactional
    @Override
    public List<Product> findAllByProductName(String productName) {
        List<Product> products = productRepository.findAllByProductName(productName);
        return products;
    }
}
