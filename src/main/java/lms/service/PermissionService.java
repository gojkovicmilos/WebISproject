package lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import lms.domain.Permission;
import lms.repository.PermissionRepository;

@Service
public class PermissionService {
	@Autowired
	PermissionRepository permissionRepository;
	
	@EventListener
    public void appReady(ApplicationReadyEvent event) {

        permissionRepository.save(new Permission(null, "ROLE_ADMIN", null));
        permissionRepository.save(new Permission(null, "ROLE_TEACHER", null));
        permissionRepository.save(new Permission(null, "ROLE_STUDENT", null));
    }

}
