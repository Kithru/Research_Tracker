package lk.ijse.cmjd.service;

import java.util.List;
import java.util.Optional;

import lk.ijse.cmjd.project.Project;

public interface ProjectService {

    Project createProject(Project project);

    Project updateProject(String id, Project updatedProject);

    List<Project> getAllProjects();

    Optional<Project> getProjectById(String id);

    Project updateStatus(String id, String status);

    void deleteProject(String id);
}
