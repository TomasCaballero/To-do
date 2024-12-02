package net.javaspringboot.to_do_app_backend.repository;

import net.javaspringboot.to_do_app_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
