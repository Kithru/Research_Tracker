package lk.ijse.cmjd.service;

import lk.ijse.cmjd.model.Project;
import java.util.List;

public interface ProjectService {

    Project createProject(Project project);

    Project updateProject(String id, Project project);

    List<Project> getAllProjects();

    Project getProjectById(String id);

    Project updateStatus(String id, String status);

    void deleteProject(String id);
}
