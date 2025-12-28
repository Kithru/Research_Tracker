package lk.ijse.cmjd.repository;

import lk.ijse.cmjd.model.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MilestoneRepository extends JpaRepository<Milestone, String> {

    List<Milestone> findByProjectId(String projectId);
}
