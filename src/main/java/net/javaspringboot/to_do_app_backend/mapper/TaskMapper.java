package net.javaspringboot.to_do_app_backend.mapper;
import net.javaspringboot.to_do_app_backend.dto.TaskDto;
import net.javaspringboot.to_do_app_backend.entity.Task;


public class TaskMapper {

    public static TaskDto mapToTaskDto(Task task){
        return new TaskDto(
                task.getId(),
                task.getUser(),
                task.getTitle(),
                task.getDate(),
                task.getContent()
        );
    }

    public static Task mapToTask(TaskDto taskDto) {
        return new Task(
                taskDto.getId(),
                taskDto.getUser(),
                taskDto.getTitle(),
                taskDto.getDate(),
                taskDto.getContent()
        );
    }
}
