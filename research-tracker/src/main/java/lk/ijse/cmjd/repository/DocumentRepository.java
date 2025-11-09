package lk.ijse.cmjd.repository;

import lk.ijse.cmjd.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, String> {

    List<Document> findByProjectId(String projectId);
}
