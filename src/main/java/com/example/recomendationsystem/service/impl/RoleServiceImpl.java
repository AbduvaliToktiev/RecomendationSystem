package com.example.recomendationsystem.service.impl;

import com.example.recomendationsystem.entity.Role;
import com.example.recomendationsystem.repository.RoleRepository;
import com.example.recomendationsystem.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getRoleByName(String name) {
        return roleRepository.findAllByName(name);
    }
}
