package net.javaguides.springboot.tutorial.repository;

import net.javaguides.springboot.tutorial.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    List<User> findByName(String name);
}
