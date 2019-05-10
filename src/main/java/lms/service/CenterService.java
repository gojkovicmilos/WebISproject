package lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.repository.CenterRepository;

@Service
public class CenterService {
	
	@Autowired
	CenterRepository centerRepository;

}
