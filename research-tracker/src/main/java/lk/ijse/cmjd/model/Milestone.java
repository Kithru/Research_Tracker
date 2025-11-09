package lk.ijse.cmjd.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "milestones")
@Data
public class Milestone {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    private String title;

    @Column(length = 2000)
    private String description;

    private LocalDate dueDate;

    private Boolean completed = false; // ✅ renamed for cleaner getter/setter

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    public Milestone() {
    }

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
