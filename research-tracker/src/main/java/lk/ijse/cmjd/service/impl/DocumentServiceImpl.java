package lk.ijse.cmjd.service.impl;

import lk.ijse.cmjd.model.Document;
import lk.ijse.cmjd.repository.DocumentRepository;
import lk.ijse.cmjd.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public Document uploadDocument(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public List<Document> getDocumentsByProjectId(String projectId) {
        return documentRepository.findByProjectId(projectId);
    }

    @Override
    public void deleteDocument(String id) {
        documentRepository.deleteById(id);
    }
}
