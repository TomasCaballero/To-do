package net.javaspringboot.to_do_app_backend.mapper;

import net.javaspringboot.to_do_app_backend.dto.UserDto;
import net.javaspringboot.to_do_app_backend.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getTasks()
        );
    }

    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getTasks()
        );
    }
}
