package com.example.recomendationsystem.dto;

import com.example.recomendationsystem.entity.User;
import com.example.recomendationsystem.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private Long id;
    private String username;
    private Integer age;
    private Gender gender;
    private String email;

    public User toUser(){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setAge(age);
        user.setGender(gender);
        user.setEmail(email);
        return user;
    }

    public static UserDto fromUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setAge(user.getAge());
        userDto.setGender(user.getGender());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
