package lk.ijse.cmjd.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.cmjd.model.User;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * User registration endpoint Password will be encoded inside AuthService
     * Password will not be returned in response
     */
    @PostMapping("/signup")
    public ResponseEntity<UserResponse> signup(@RequestBody User user) {
        User savedUser = authService.register(user);
        return ResponseEntity.ok(
                new UserResponse(
                        savedUser.getId(), // UUID string
                        savedUser.getUsername(),
                        savedUser.getRole().name() // convert enum to string
                )
        );
    }

    /**
     * Login endpoint Returns JWT token if credentials are correct
     */
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {
        String token = authService.login(request.username(), request.password());
        return ResponseEntity.ok(new JwtResponse(token));
    }

    // DTOs
    public static record LoginRequest(String username, String password) {

    }

    public static record JwtResponse(String token) {

    }

    public static record UserResponse(String id, String username, String role) {

    }
}
