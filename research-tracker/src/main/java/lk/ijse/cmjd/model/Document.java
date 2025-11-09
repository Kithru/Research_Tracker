package lk.ijse.cmjd.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "documents")
@Data
public class Document {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    private String title;

    @Column(length = 2000)
    private String description;

    private String urlOrPath;

    @ManyToOne
    @JoinColumn(name = "uploaded_by")
    private User uploadedBy;

    private LocalDateTime uploadedAt;

    public Document() {
    }

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
        if (uploadedAt == null) {
            uploadedAt = LocalDateTime.now();
        }
    }

}
