package lk.ijse.cmjd.researchtracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.ijse.cmjd.researchtracker.model.Milestone;

public interface MilestoneRepository extends JpaRepository<Milestone, String> {

    List<Milestone> findByProjectId(String projectId);
}
