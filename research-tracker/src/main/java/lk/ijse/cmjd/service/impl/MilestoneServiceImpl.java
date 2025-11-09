package lk.ijse.cmjd.service.impl;

import lk.ijse.cmjd.model.Milestone;
import lk.ijse.cmjd.repository.MilestoneRepository;
import lk.ijse.cmjd.service.MilestoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MilestoneServiceImpl implements MilestoneService {

    @Autowired
    private MilestoneRepository milestoneRepository;

    @Override
    public Milestone createMilestone(Milestone milestone) {
        return milestoneRepository.save(milestone);
    }

    @Override
    public Milestone updateMilestone(String id, Milestone milestone) {
        Milestone existing = milestoneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Milestone not found with id: " + id));

        // ✅ Safely update fields
        existing.setTitle(milestone.getTitle());
        existing.setDescription(milestone.getDescription());
        existing.setDueDate(milestone.getDueDate());
        existing.setCompleted(milestone.getCompleted()); // fixed naming

        return milestoneRepository.save(existing);
    }

    @Override
    public List<Milestone> getMilestonesByProjectId(String projectId) {
        return milestoneRepository.findByProjectId(projectId);
    }

    @Override
    public void deleteMilestone(String id) {
        if (!milestoneRepository.existsById(id)) {
            throw new RuntimeException("Milestone not found with id: " + id);
        }
        milestoneRepository.deleteById(id);
    }
}
