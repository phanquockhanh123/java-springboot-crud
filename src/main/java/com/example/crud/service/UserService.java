package com.example.crud.service;

import com.example.crud.dto.GetUserRequest;
import com.example.crud.dto.UserDto;
import com.example.crud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDto> searchUsers(GetUserRequest searchReq) {
        return userRepository.findByUsernameAndAddress(searchReq.getUsername(), searchReq.getAddress());
    }
}
