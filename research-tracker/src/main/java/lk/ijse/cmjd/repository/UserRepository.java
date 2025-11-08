package lk.ijse.cmjd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.ijse.cmjd.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
