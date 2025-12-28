package lk.ijse.cmjd.researchtracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.ijse.cmjd.researchtracker.model.Document;

public interface DocumentRepository extends JpaRepository<Document, String> {

    List<Document> findByProjectId(String projectId);
}
