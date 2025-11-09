package lk.ijse.cmjd.repository;

import lk.ijse.cmjd.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, String> {

    /////////////// Projects assigned to a PI  ///////////////
    @Query("SELECT p FROM Project p WHERE p.pi.username = :username")
    List<Project> findByPiUsername(@Param("username") String username);

    /////////////// Projects assigned to a Member  ///////////////
    @Query("SELECT p FROM Project p JOIN p.members m WHERE m.username = :username")
    List<Project> findByMemberUsername(@Param("username") String username);

    /////////////// Public projects for viewers  ///////////////
    @Query("SELECT p FROM Project p WHERE p.status = 'PUBLIC'")
    List<Project> findByStatusPublic();
}
