package net.javaspringboot.to_do_app_backend.service.implementation;

import lombok.AllArgsConstructor;
import net.javaspringboot.to_do_app_backend.dto.UserDto;
import net.javaspringboot.to_do_app_backend.entity.User;
import net.javaspringboot.to_do_app_backend.exception.ResourceNotFoundException;
import net.javaspringboot.to_do_app_backend.mapper.UserMapper;
import net.javaspringboot.to_do_app_backend.repository.UserRepository;
import net.javaspringboot.to_do_app_backend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("No existe usuario con ID: "+userId));

        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users= userRepository.findAll();
        List<UserDto> usersDto = new ArrayList<>();

        for(User user : users){
            usersDto.add(UserMapper.mapToUserDto(user));
        }

        return usersDto;
    }
}
