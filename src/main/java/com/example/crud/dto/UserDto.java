package com.example.crud.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private String id;
    private String username;
    private String password;

    public UserDto(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
