package com.oach.boardgame.app.services;

import java.util.List;

import com.oach.boardgame.app.models.Address;

public interface IAddressService {
	

	Address createAddress(Address address);
	
	List<Address> getAllAddress();
	
	Address getAddressById(String id);
	
	Address updateAddress(Address address);
	
	boolean deleteAddressById(String id);

}
