package lk.ijse.cmjd.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.cmjd.model.User;
import lk.ijse.cmjd.service.UserService;

@RestController
@RequestMapping("/api/users")
@PreAuthorize("hasRole('ADMIN')") // Only admins can access
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // Get all users (without password)
    @GetMapping
    public ResponseEntity<List<UserResponse>> all() {
        List<UserResponse> users = service.getAllUsers()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    // Get single user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> get(@PathVariable String id) {
        return service.getUserById(id)
                .map(this::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Register a new user
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody User user) {
        User savedUser = service.registerUser(user);
        return ResponseEntity.ok(toResponse(savedUser));
    }

    // Delete a user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // Helper method to convert User entity to DTO
    private UserResponse toResponse(User user) {
        return new UserResponse(user.getId(), user.getUsername(), user.getFullName(), user.getRole().name());
    }

    // DTO
    public static record UserResponse(String id, String username, String fullName, String role) {

    }
}
