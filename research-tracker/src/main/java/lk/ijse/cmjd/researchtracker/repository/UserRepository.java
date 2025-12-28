package lk.ijse.cmjd.researchtracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.ijse.cmjd.researchtracker.model.User;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUsername(String username);
}
