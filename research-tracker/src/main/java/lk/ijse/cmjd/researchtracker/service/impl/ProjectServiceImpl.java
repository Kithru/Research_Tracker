package lk.ijse.cmjd.service.impl;

import lk.ijse.cmjd.model.Project;
import lk.ijse.cmjd.model.Status;
import lk.ijse.cmjd.repository.ProjectRepository;
import lk.ijse.cmjd.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    // ==================== CRUD ====================
    @Override
    public Project createProject(Project project) {
        project.setCreatedAt(LocalDateTime.now());
        project.setUpdatedAt(LocalDateTime.now());
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(String id, Project updatedProject) {
        Project existing = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));

        existing.setTitle(updatedProject.getTitle());
        existing.setSummary(updatedProject.getSummary());
        existing.setTags(updatedProject.getTags());
        existing.setStartDate(updatedProject.getStartDate());
        existing.setEndDate(updatedProject.getEndDate());
        existing.setUpdatedAt(LocalDateTime.now());

        return projectRepository.save(existing);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(String id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));
    }

    @Override
    public Project updateStatus(String id, Status status) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));

        project.setStatus(status);
        project.setUpdatedAt(LocalDateTime.now());
        return projectRepository.save(project);
    }

    @Override
    public void deleteProject(String id) {
        if (!projectRepository.existsById(id)) {
            throw new RuntimeException("Project not found with id: " + id);
        }
        projectRepository.deleteById(id);
    }

    // ==================== ROLE-SPECIFIC METHODS ====================
    @Override
    public List<Project> getProjectsByPI(String username) {
        return projectRepository.findByPiUsername(username); // Implement in ProjectRepository
    }

    @Override
    public List<Project> getProjectsForMember(String username) {
        return projectRepository.findByMemberUsername(username); // Implement in ProjectRepository
    }

    @Override
    public List<Project> getPublicProjects() {
        return projectRepository.findByStatusPublic(); // Implement in ProjectRepository
    }
}
