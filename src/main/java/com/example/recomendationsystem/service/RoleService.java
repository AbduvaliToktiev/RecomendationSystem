package com.example.recomendationsystem.service;

import com.example.recomendationsystem.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoleByName(String name);
}
