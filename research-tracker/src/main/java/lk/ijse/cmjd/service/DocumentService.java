package lk.ijse.cmjd.service;

import lk.ijse.cmjd.model.Document;
import java.util.List;

public interface DocumentService {

    Document uploadDocument(Document document);

    List<Document> getDocumentsByProjectId(String projectId);

    void deleteDocument(String id);
}
