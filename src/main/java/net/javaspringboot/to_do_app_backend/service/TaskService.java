package net.javaspringboot.to_do_app_backend.service;

import net.javaspringboot.to_do_app_backend.dto.TaskDto;
import net.javaspringboot.to_do_app_backend.dto.UserDto;

public interface TaskService {
    TaskDto createTask(TaskDto taskDto);

    TaskDto getTaskById(Long id);
}
