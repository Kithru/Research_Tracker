package lk.ijse.cmjd.auth;

import lk.ijse.cmjd.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody User user) {
        User savedUser = authService.register(user);
        ////////////////  Don’t return password in response  /////////////////
        savedUser.setPassword(null);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {
        String token = authService.login(request.username(), request.password());
        return ResponseEntity.ok(new JwtResponse(token));
    }

    public static record LoginRequest(String username, String password) {

    }

    public static record JwtResponse(String token) {

    }
}
