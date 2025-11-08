package lk.ijse.cmjd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.ijse.cmjd.model.Milestone;

@Repository
public interface MilestoneRepository extends JpaRepository<Milestone, String> {

}
