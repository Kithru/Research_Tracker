package lk.ijse.cmjd.service.impl;

import lk.ijse.cmjd.model.Project;
import lk.ijse.cmjd.model.Status;
import lk.ijse.cmjd.repository.ProjectRepository;
import lk.ijse.cmjd.service.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository repo;

    public ProjectServiceImpl(ProjectRepository repo) {
        this.repo = repo;
    }

    @Override
    public Project createProject(Project project) {
        return repo.save(project);
    }

    @Override
    public Project updateProject(String id, Project project) {
        Project existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        existing.setTitle(project.getTitle());
        existing.setSummary(project.getSummary());
        existing.setEndDate(project.getEndDate());
        existing.setStartDate(project.getStartDate());
        existing.setTags(project.getTags());
        existing.setPi(project.getPi());
        return repo.save(existing);
    }

    @Override
    public List<Project> getAllProjects() {
        return repo.findAll();
    }

    @Override
    public Project getProjectById(String id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
    }

    @Override
    public Project updateStatus(String id, String status) {
        Project p = getProjectById(id);
        p.setStatus(Status.valueOf(status));
        return repo.save(p);
    }

    @Override
    public void deleteProject(String id) {
        repo.deleteById(id);
    }
}
