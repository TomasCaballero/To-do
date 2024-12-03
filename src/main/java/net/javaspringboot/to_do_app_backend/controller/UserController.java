package net.javaspringboot.to_do_app_backend.controller;

import lombok.AllArgsConstructor;
import net.javaspringboot.to_do_app_backend.dto.UserDto;
import net.javaspringboot.to_do_app_backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;


    // POST CREAR USUARIO
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // GET OBTENER USUARIO POR ID
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }


    // GET OBTENER TODOS LOS USUARIOS
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // POST MODIFICAR DATOS DE USUARIO POR ID
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId, @RequestBody UserDto updateUser){
        UserDto userUpdated = userService.updateUser(userId, updateUser);
        return ResponseEntity.ok(userUpdated);
    }
}
