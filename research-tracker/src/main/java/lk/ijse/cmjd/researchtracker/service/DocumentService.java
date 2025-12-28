package lk.ijse.cmjd.service;

import lk.ijse.cmjd.model.Document;
import java.util.List;

public interface DocumentService {

    List<Document> getByProject(String projectId);

    Document createForProject(String projectId, Document document);

    void delete(String id);

    List<Document> getAllDocuments();
}
