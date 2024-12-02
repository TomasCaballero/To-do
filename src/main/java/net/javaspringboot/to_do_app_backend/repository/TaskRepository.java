package net.javaspringboot.to_do_app_backend.repository;

import net.javaspringboot.to_do_app_backend.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
