package com.example.recomendationsystem.service.impl;

import com.example.recomendationsystem.entity.Favorites;
import com.example.recomendationsystem.repository.FavoritesRepository;
import com.example.recomendationsystem.service.FavoritesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FavoritesServiceImpl implements FavoritesService {

    private final FavoritesRepository favoritesRepository;

    @Autowired
    public FavoritesServiceImpl(FavoritesRepository favoritesRepository) {
        this.favoritesRepository = favoritesRepository;
    }

    @Override
    public Favorites save(Favorites favorites) {
        favoritesRepository.save(favorites);
        return favorites;
    }

    @Override
    public List<Favorites> findAll() {
        return favoritesRepository.findAll();
    }
}
