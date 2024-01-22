package com.example.crud.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class GetUserRequest {
    private String username;
    private String address;
}
