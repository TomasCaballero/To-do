package net.javaspringboot.to_do_app_backend.service;

import net.javaspringboot.to_do_app_backend.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();
}