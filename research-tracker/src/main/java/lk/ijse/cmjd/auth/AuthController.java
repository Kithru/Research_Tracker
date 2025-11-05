package lk.ijse.cmjd.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String username,
            @RequestParam String password,
            @RequestParam String fullName) {
        return authService.signup(username, password, fullName);
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
            @RequestParam String password) {
        return authService.login(username, password);
    }
}
