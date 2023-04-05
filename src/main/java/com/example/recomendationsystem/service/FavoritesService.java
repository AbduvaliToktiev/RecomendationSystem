package com.example.recomendationsystem.service;

import com.example.recomendationsystem.entity.Favorites;

import java.util.List;

public interface FavoritesService {

    Favorites save(Favorites favorites);

    List<Favorites> findAll();
}
