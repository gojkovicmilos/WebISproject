package lms.plugin.chat.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.domain.Student;
import lms.plugin.chat.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByUserName(String userName);
}
