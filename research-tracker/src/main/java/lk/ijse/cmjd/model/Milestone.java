package lk.ijse.cmjd.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Milestone {

    @Id
    private String id;

    @ManyToOne
    private Project project;

    private String title;
    private String description;
    private LocalDate dueDate;
    private Boolean isCompleted;

    @ManyToOne
    private User createdBy;
}
