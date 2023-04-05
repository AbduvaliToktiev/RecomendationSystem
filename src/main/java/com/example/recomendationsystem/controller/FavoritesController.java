package com.example.recomendationsystem.controller;

import com.example.recomendationsystem.entity.Favorites;
import com.example.recomendationsystem.entity.Product;
import com.example.recomendationsystem.enums.Reaction;
import com.example.recomendationsystem.service.FavoritesService;
import com.example.recomendationsystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users/")
public class FavoritesController {

    private final FavoritesService favoritesService;
    private final ProductService productService;

    @Autowired
    public FavoritesController(FavoritesService favoritesService, ProductService productService) {
        this.favoritesService = favoritesService;
        this.productService = productService;
    }

    @PostMapping(value = "saveFavorites")
    public String saveReaction(@RequestParam Long productId,
                               @RequestParam String reaction) {
        Favorites favorites = new Favorites();
        Product product = productService.findById(productId);

        favorites.setProduct(product);
        favorites.setReaction(Reaction.valueOf(reaction));
        favoritesService.save(favorites);
        return "THANKS";
    }

    @GetMapping(value = "favorites")
    public List<Favorites> findAll() {
         return favoritesService.findAll();
    }
}
