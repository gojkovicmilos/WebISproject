package lms.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import lms.domain.Permission;
import lms.repository.PermissionRepository;

@Service
public class PermissionService implements CommandLineRunner{
	@Autowired
	PermissionRepository permissionRepository;

	
	@Override
	public void run(String... args) throws Exception {
        permissionRepository.save(new Permission(1l, "ROLE_ADMIN", null));
        permissionRepository.save(new Permission(2l, "ROLE_TEACHER", null));
        permissionRepository.save(new Permission(3l, "ROLE_STUDENT", null));
	}
	
}
