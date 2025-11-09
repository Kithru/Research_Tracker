package lk.ijse.cmjd.repository;

import lk.ijse.cmjd.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, String> {
}
