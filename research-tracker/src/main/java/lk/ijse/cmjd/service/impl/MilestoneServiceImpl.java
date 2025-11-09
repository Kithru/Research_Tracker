package lk.ijse.cmjd.service.impl;

import lk.ijse.cmjd.model.Milestone;
import lk.ijse.cmjd.model.Project;
import lk.ijse.cmjd.repository.MilestoneRepository;
import lk.ijse.cmjd.repository.ProjectRepository;
import lk.ijse.cmjd.service.MilestoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MilestoneServiceImpl implements MilestoneService {

    @Autowired
    private MilestoneRepository milestoneRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Milestone createForProject(String projectId, Milestone milestone) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + projectId));
        milestone.setProject(project);
        return milestoneRepository.save(milestone);
    }

    @Override
    public Milestone update(String id, Milestone milestone) {
        Milestone existing = milestoneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Milestone not found with id: " + id));

        existing.setTitle(milestone.getTitle());
        existing.setDescription(milestone.getDescription());
        existing.setDueDate(milestone.getDueDate());
        existing.setCompleted(milestone.getCompleted());

        return milestoneRepository.save(existing);
    }

    @Override
    public List<Milestone> getByProject(String projectId) {
        return milestoneRepository.findByProjectId(projectId);
    }

    @Override
    public void delete(String id) {
        if (!milestoneRepository.existsById(id)) {
            throw new RuntimeException("Milestone not found with id: " + id);
        }
        milestoneRepository.deleteById(id);
    }
}
