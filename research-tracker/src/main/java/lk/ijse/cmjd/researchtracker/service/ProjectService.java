package lk.ijse.cmjd.researchtracker.service;

import java.util.List;

import lk.ijse.cmjd.researchtracker.model.Project;
import lk.ijse.cmjd.researchtracker.model.Status;

public interface ProjectService {

    //////////////////// CRUD operations ////////////////////
    Project createProject(Project project);

    Project updateProject(String id, Project updatedProject);

    List<Project> getAllProjects();

    Project getProjectById(String id);

    Project updateStatus(String id, Status status);

    void deleteProject(String id);

    //////////////// Projects assigned to a PI  ////////////////
    List<Project> getProjectsByPI(String username);

    //////////////// Projects assigned to a Member   ////////////////
    List<Project> getProjectsForMember(String username);

    //////////////// Public projects accessible to Viewer   ////////////////
    List<Project> getPublicProjects();

}
