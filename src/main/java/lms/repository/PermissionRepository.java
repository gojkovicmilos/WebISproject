package lms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lms.domain.Permission;

@Repository
public interface PermissionRepository extends CrudRepository<Permission, Long>{
	
}
