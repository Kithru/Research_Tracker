package lk.ijse.cmjd.researchtracker.auth;

import lk.ijse.cmjd.researchtracker.model.User;
import lk.ijse.cmjd.researchtracker.model.UserRole;
import lk.ijse.cmjd.researchtracker.repository.UserRepository;
import lk.ijse.cmjd.researchtracker.config.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepo;
    private final BCryptPasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepo, BCryptPasswordEncoder encoder, JwtUtil jwtUtil) {
        this.userRepo = userRepo;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        if (user.getRole() == null) {
            user.setRole(UserRole.MEMBER);
        }
        return userRepo.save(user);
    }

    public String login(String username, String password) {
        return userRepo.findByUsername(username)
                .filter(u -> encoder.matches(password, u.getPassword()))
                .map(u -> jwtUtil.generateToken(u.getUsername()))
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }
}
