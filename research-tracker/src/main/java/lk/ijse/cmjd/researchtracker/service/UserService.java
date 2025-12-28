package lk.ijse.cmjd.researchtracker.service;

import java.util.List;
import java.util.Optional;

import lk.ijse.cmjd.researchtracker.model.User;

public interface UserService {

    List<User> getAllUsers();

    Optional<User> getUserById(String id);

    User registerUser(User user);

    void deleteUser(String id);
}
