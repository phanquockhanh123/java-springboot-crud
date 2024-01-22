package com.example.crud.controller;

import com.example.crud.dto.GetUserRequest;
import com.example.crud.dto.UserDto;
import com.example.crud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v2")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers(
            @RequestParam(name = "username", required = false) String username,
            @RequestParam(name = "address", required = false) String address

    ) {
        return ResponseEntity.ok(userService.searchUsers(new GetUserRequest(username, address)));
    }

}
