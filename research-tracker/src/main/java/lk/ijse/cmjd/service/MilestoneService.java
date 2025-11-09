package lk.ijse.cmjd.service;

import lk.ijse.cmjd.model.Milestone;
import java.util.List;

public interface MilestoneService {

    Milestone createForProject(String projectId, Milestone milestone);

    Milestone update(String id, Milestone milestone);

    List<Milestone> getByProject(String projectId);

    void delete(String id);

    List<Milestone> getAllMilestones();
}
