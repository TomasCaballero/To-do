package net.javaspringboot.to_do_app_backend.controller;


import lombok.AllArgsConstructor;
import net.javaspringboot.to_do_app_backend.dto.TaskDto;
import net.javaspringboot.to_do_app_backend.dto.UserDto;
import net.javaspringboot.to_do_app_backend.service.TaskService;
import net.javaspringboot.to_do_app_backend.service.implementation.TaskServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto){
        TaskDto savedTask = taskService.createTask(taskDto);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    // OBTENER TAREA POR ID
    @GetMapping("{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable("id") Long taskId){
        TaskDto task = taskService.getTaskById(taskId);
        return ResponseEntity.ok(task);
    }

    // POST MODIFICAR DATOS DE USUARIO POR ID
    @PutMapping("{id}")
    public ResponseEntity<TaskDto> updateUser(@PathVariable("id") Long taskId, @RequestBody TaskDto updateTask){
        TaskDto taskUpdated = taskService.updateTask(taskId, updateTask);
        return ResponseEntity.ok(updateTask);
    }
}
