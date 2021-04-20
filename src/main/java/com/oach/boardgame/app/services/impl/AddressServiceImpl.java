package com.oach.boardgame.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oach.boardgame.app.models.Address;
import com.oach.boardgame.app.repositories.IAddressRepository;
import com.oach.boardgame.app.services.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService {
	
	@Autowired
	IAddressRepository repository;

	@Override
	public Address createAddress(Address address) {
		return repository.save(address);
	}

	@Override
	public List<Address> getAllAddress() {
		return repository.findAll();
	}

	@Override
	public Address getAddressById(String id) {
		return repository.findById(id).orElse(null);
		
		}

	@Override
	public Address updateAddress(Address address) {
		if(repository.existsById(address.getId())) {
			return repository.save(address);
		}
	return null;	
	}

	@Override
	public boolean deleteAddressById(String id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

}
