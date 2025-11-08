package lk.ijse.cmjd.model;

import java.time.LocalDateTime;

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

public class Document {

    @Id
    private String id;

    @ManyToOne
    private Project project;

    private String title;
    private String description;
    private String urlOrPath;

    @ManyToOne
    private User uploadedBy;

    private LocalDateTime uploadedAt;
}
