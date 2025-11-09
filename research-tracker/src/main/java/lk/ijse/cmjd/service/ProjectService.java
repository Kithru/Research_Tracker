package lk.ijse.cmjd.service;

import lk.ijse.cmjd.model.Project;
import lk.ijse.cmjd.model.Status;

import java.util.List;

public interface ProjectService {

    Project createProject(Project project);

    Project updateProject(String id, Project updatedProject);

    List<Project> getAllProjects();

    Project getProjectById(String id);

    Project updateStatus(String id, Status status);

    void deleteProject(String id);
}
