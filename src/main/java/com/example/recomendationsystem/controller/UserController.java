package com.example.recomendationsystem.controller;

import com.example.recomendationsystem.dto.UserDto;
import com.example.recomendationsystem.entity.User;
import com.example.recomendationsystem.service.RoleService;
import com.example.recomendationsystem.service.UserService;
import com.example.recomendationsystem.service.impl.RoleServiceImpl;
import com.example.recomendationsystem.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/users/")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostMapping(value = "registration")
    public String registration(@RequestBody User user) {
        userService.register(user);
        user.setRoles(roleService.getRoleByName("ROLE_USER"));
        return "SUCCESS";
    }


    @GetMapping(value = "{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id){
        User user = userService.findById(id);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserDto result = UserDto.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
