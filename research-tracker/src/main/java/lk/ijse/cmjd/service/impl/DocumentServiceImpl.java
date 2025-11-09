package lk.ijse.cmjd.service.impl;

import lk.ijse.cmjd.model.Document;
import lk.ijse.cmjd.model.Project;
import lk.ijse.cmjd.repository.DocumentRepository;
import lk.ijse.cmjd.repository.ProjectRepository;
import lk.ijse.cmjd.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Document> getByProject(String projectId) {
        return documentRepository.findByProjectId(projectId);
    }

    @Override
    public Document createForProject(String projectId, Document document) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + projectId));
        document.setProject(project);
        return documentRepository.save(document);
    }

    @Override
    public void delete(String id) {
        documentRepository.deleteById(id);
    }

    @Override
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }
}
