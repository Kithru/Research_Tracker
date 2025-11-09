package lk.ijse.cmjd.service;

import lk.ijse.cmjd.model.*;
import java.util.List;
import java.util.Optional;

public interface ProjectService {

    Project createProject(Project project);

    Project updateProject(String id, Project updatedProject);

    List<Project> getAllProjects();

    Optional<Project> getProjectById(String id);

    Project updateStatus(String id, Status status);

    void deleteProject(String id);
}
