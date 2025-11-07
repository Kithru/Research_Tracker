package lk.ijse.cmjd.project;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lk.ijse.cmjd.common.Status;
import lk.ijse.cmjd.user.User; // ✅ Correct import
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    private String id;

    private String title;
    private String summary;

    @Enumerated(EnumType.STRING)
    private Status status; // ✅ Uses your custom enum

    @ManyToOne
    private User pi;

    private String tags;
    private LocalDate startDate;
    private LocalDate endDate;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
