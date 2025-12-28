package lk.ijse.cmjd.service;

import lk.ijse.cmjd.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    Optional<User> getUserById(String id);

    User registerUser(User user);

    void deleteUser(String id);
}
