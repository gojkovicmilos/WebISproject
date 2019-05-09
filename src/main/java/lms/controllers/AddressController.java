package lms.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.domain.Address;
import lms.service.AddressService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	AddressService addressService;

	@RequestMapping()
	public ResponseEntity<Iterable<Address>> getCountry() {
		return new ResponseEntity<Iterable<Address>>(addressService.getAddress(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Address> getCountryById(@PathVariable Long id) {
		Optional<Address> address = addressService.getAddressById(id);
		if (address.isPresent()) {
			return new ResponseEntity<Address>(address.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Address> dodavanjeKorisnika(@RequestBody Address address) {

		addressService.addAdress(address);
		return new ResponseEntity<Address>(address, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Address> updateCountry(@PathVariable Long id, @RequestBody Address address) {
		addressService.updateAddress(id, address);
		return new ResponseEntity<Address>(address, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Address> removeCountry(@PathVariable Long id) {
		try {
			addressService.removeAddress(id);
		} catch (Exception e) {
			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Address>(HttpStatus.NO_CONTENT);
	}
}
