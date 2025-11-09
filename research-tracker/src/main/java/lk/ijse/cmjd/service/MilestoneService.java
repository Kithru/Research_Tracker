package lk.ijse.cmjd.service;

import lk.ijse.cmjd.model.Milestone;
import java.util.List;

public interface MilestoneService {

    Milestone createMilestone(Milestone milestone);

    Milestone updateMilestone(String id, Milestone milestone);

    List<Milestone> getMilestonesByProjectId(String projectId);

    void deleteMilestone(String id);
}
