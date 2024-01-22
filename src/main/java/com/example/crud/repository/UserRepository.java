package com.example.crud.repository;

import com.example.crud.dto.GetUserRequest;
import com.example.crud.dto.UserDto;
import com.example.crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String>  {
    @Query("select new com.example.crud.dto.UserDto(id, username, address) from User where username = :username and address = :address ")
    List<UserDto> findByUsernameAndAddress(String username, String address);

//    @Query("select a from User a where a.address = :address and a.username = :username ")
//    List<User> findByUsernameAndAddressxx(String address, String username);
//
//    List<User> findByUsernameAndAddress(String username, String address);

}
