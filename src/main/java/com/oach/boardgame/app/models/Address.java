package com.oach.boardgame.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Addresses")	
public class Address {

	@Id
	private String id;
	
	private String addressLine1;
	private String city;
	private String province;
	private int postalCode;
	private String country;
	private String moreInformation;
	
	 Address() {
		
	}
	
	public Address(String addressLine1, String city, String province, int postalCode,
			String country, String moreInformation) {
		this.addressLine1 = addressLine1;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
		this.country = country;
		this.moreInformation = moreInformation;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMoreInformation() {
		return moreInformation;
	}

	public void setMoreInformation(String moreInformation) {
		this.moreInformation = moreInformation;
	}
	
	
}
