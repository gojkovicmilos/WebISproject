package lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.Address;
import lms.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	public List<Address> findAll(){
		return addressRepository.findAll();
	}
	
	public void addAdress(Address a) {
		addressRepository.save(a);
	}
	
	public Optional<Address> getStudent(Long id) {
		return addressRepository.findById(id);
	}
	
	
	public void removeStudent(Long id) {
		Optional<Address> a = addressRepository.findById(id);
		addressRepository.delete(a.get());
	}

}
