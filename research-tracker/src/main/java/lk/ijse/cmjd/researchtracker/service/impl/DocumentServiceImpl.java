package lk.ijse.cmjd.researchtracker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ijse.cmjd.researchtracker.model.Document;
import lk.ijse.cmjd.researchtracker.model.Project;
import lk.ijse.cmjd.researchtracker.repository.DocumentRepository;
import lk.ijse.cmjd.researchtracker.repository.ProjectRepository;
import lk.ijse.cmjd.researchtracker.service.DocumentService;

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
