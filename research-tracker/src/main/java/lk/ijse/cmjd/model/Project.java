package lk.ijse.cmjd.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "projects")
@Data
public class Project {

    @Id
    private String id;

    private String title;

    @Column(length = 2000)
    private String summary;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PLANNING;

    @ManyToOne
    @JoinColumn(name = "pi_id")
    private User pi;

    private String tags;

    private LocalDate startDate;
    private LocalDate endDate;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Project() {
    }

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
