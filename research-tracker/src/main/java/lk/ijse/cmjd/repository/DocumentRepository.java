package lk.ijse.cmjd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.ijse.cmjd.model.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, String> {

}
