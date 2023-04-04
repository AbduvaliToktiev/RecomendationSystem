package com.example.recomendationsystem.dto;

import com.example.recomendationsystem.entity.User;
import com.example.recomendationsystem.enums.Gender;
import com.example.recomendationsystem.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserDto {

    private Long id;
    private String username;
    private Integer age;
    private Gender gender;
    private String email;
    private String status;

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setAge(age);
        user.setGender(gender);
        user.setEmail(email);
        user.setStatus(Status.valueOf(status));
        return user;
    }

    public static AdminUserDto fromUser(User user) {
        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setId(user.getId());
        adminUserDto.setUsername(user.getUsername());
        adminUserDto.setAge(user.getAge());
        adminUserDto.setGender(user.getGender());
        adminUserDto.setEmail(user.getEmail());
        adminUserDto.setStatus(user.getStatus().name());
        return adminUserDto;
    }
}
