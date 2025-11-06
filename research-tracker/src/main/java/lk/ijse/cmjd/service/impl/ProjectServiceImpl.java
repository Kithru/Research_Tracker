package lk.ijse.cmjd.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.researchtracker.model.Project;
import lk.ijse.cmjd.project.ProjectRepository;
import lk.ijse.cmjd.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project createProject(Project project) {
        project.setCreatedAt(LocalDateTime.now());
        project.setUpdatedAt(LocalDateTime.now());
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(String id, Project updatedProject) {
        Optional<Project> existingProject = projectRepository.findById(id);
        if (existingProject.isPresent()) {
            Project project = existingProject.get();
            project.setTitle(updatedProject.getTitle());
            project.setSummary(updatedProject.getSummary());
            project.setStatus(updatedProject.getStatus());
            project.setPi(updatedProject.getPi());
            project.setTags(updatedProject.getTags());
            project.setStartDate(updatedProject.getStartDate());
            project.setEndDate(updatedProject.getEndDate());
            project.setUpdatedAt(LocalDateTime.now());
            return projectRepository.save(project);
        }
        throw new RuntimeException("Project not found with ID: " + id);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> getProjectById(String id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project updateStatus(String id, String status) {
        Optional<Project> existingProject = projectRepository.findById(id);
        if (existingProject.isPresent()) {
            Project project = existingProject.get();
            project.setStatus(Project.status.valueOf(status.toUpperCase()));
            project.setUpdatedAt(LocalDateTime.now());
            return projectRepository.save(project);
        }
        throw new RuntimeException("Project not found with ID: " + id);
    }

    @Override
    public void deleteProject(String id) {
        projectRepository.deleteById(id);
    }
}
