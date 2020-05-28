package ru.job4j.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.model.User;
@Repository
public interface UserRepo extends JpaRepository<User,Long> {
  User findByUsername(String username);
  User findUserById(Long id);
}
