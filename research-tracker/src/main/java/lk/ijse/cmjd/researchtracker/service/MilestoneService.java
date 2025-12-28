package lk.ijse.cmjd.researchtracker.service;

import java.util.List;

import lk.ijse.cmjd.researchtracker.model.Milestone;

public interface MilestoneService {

    Milestone createForProject(String projectId, Milestone milestone);

    Milestone update(String id, Milestone milestone);

    List<Milestone> getByProject(String projectId);

    void delete(String id);

    List<Milestone> getAllMilestones();
}
