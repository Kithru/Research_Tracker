package lk.ijse.cmjd.user;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lk.ijse.cmjd.common.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;
    private String username;
    private String password;
    private String fullName;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private LocalDateTime createdAt;

}
