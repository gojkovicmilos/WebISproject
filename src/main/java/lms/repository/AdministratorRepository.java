package lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.domain.Administrator;
// cao
@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long>{

	

}
