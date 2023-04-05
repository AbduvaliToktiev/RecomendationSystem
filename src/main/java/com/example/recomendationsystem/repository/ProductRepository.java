package com.example.recomendationsystem.repository;

import com.example.recomendationsystem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM recomendation_system.products WHERE product_name like %:keyword%",nativeQuery = true)
    List<Product> findByProductName(@Param("keyword") String keyword);

    List<Product> findByAuthor(String author);

    List<Product> findByGenre(String genre);

    List<Product> findAllByProductName(String productName);
}
