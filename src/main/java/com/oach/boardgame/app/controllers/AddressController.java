package com.oach.boardgame.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oach.boardgame.app.models.Address;
import com.oach.boardgame.app.services.impl.AddressServiceImpl;

@RestController
@RequestMapping("/boardGames")
public class AddressController {
	
	@Autowired
	AddressServiceImpl service;
	
	@GetMapping("/addresses")
	public List<Address> getAllAddress(){
		return service.getAllAddress();
	}
	
	@GetMapping("/addresses/{id}")
	public Address getAddress(@PathVariable("id") String id) {
		return service.getAddressById(id);
	}
	
	@PostMapping("/addresses")
	public ResponseEntity<Address> createAddress(@Validated @RequestBody Address address) {
		Address addressSaved = service.createAddress(address);
		return new ResponseEntity<Address>(addressSaved, HttpStatus.CREATED);
	}

	@PutMapping("/addresses/{id}")
	public ResponseEntity<Address> updateAddress(@Validated @RequestBody Address address, @PathVariable("id") String id){
		address.setId(id);
		Address addressUpdated = service.updateAddress(address);
		if(addressUpdated != null) {
			return new ResponseEntity<Address>(addressUpdated, HttpStatus.OK);
		}
		return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/addresses/{id}")
	public ResponseEntity<Address> deleteAddress(@PathVariable("id") String id){
		if(service.deleteAddressById(id)) {
			return new ResponseEntity<Address>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
	}
	
}
