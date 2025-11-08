package lk.ijse.cmjd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.ijse.cmjd.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {

}
