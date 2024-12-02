package net.javaspringboot.to_do_app_backend.service.implementation;

import lombok.AllArgsConstructor;
import net.javaspringboot.to_do_app_backend.dto.TaskDto;
import net.javaspringboot.to_do_app_backend.entity.Task;
import net.javaspringboot.to_do_app_backend.entity.User;
import net.javaspringboot.to_do_app_backend.exception.ResourceNotFoundException;
import net.javaspringboot.to_do_app_backend.mapper.TaskMapper;
import net.javaspringboot.to_do_app_backend.repository.TaskRepository;
import net.javaspringboot.to_do_app_backend.repository.UserRepository;
import net.javaspringboot.to_do_app_backend.service.TaskService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskServiceImplementation implements TaskService {

    private TaskRepository taskRepository;
    private UserRepository userRepository;

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        // Buscar el usuario por ID
        User user = userRepository.findById(taskDto.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + taskDto.getUser().getId()));

        Task task = TaskMapper.mapToTask(taskDto);

        // Asociar la tarea al usuario
        user.addTask(task);

        // Guardar el usuario (esto también guardará la tarea debido a CascadeType.ALL)
        userRepository.save(user);

        //Task savedTask = taskRepository.save(task);
        return TaskMapper.mapToTaskDto(task);
    }

    @Override
    public TaskDto getTaskById(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("No existe tarea con ID: "+taskId));

        return TaskMapper.mapToTaskDto(task);
    }
}
