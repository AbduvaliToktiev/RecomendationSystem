package com.example.recomendationsystem.dto;

import com.example.recomendationsystem.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String productName;
    private String author;
    private String album;
    private String genre;
    private Date yearOfIssue;

    public Product toProduct() {
        Product product = new Product();
        product.setId(id);
        product.setProductName(productName);
        product.setAuthor(author);
        product.setAlbum(album);
        product.setGenre(genre);
        product.setYearOfIssue(yearOfIssue);
        return product;
    }

    public static ProductDto fromProduct(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setProductName(product.getProductName());
        productDto.setAuthor(product.getAuthor());
        productDto.setAlbum(product.getAlbum());
        productDto.setGenre(product.getGenre());
        productDto.setYearOfIssue(product.getYearOfIssue());
        return productDto;
    }
}
