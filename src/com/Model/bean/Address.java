package com.Model.bean;

public class Address extends City{
private int id,number,postcode;
private String street,district,complement;

public Address() {
}

public Address(int countryId, String countryName, String countryCode, int stateId, String stateName, String stateCode,int cityId, String cityName, String cityCode,int id, int number, int postcode, String street, String district, String complement) {
	super(countryId,countryName,countryCode,stateId,stateName,stateCode,cityId,cityName,cityCode);
	this.id = id;
	this.number = number;
	this.postcode = postcode;
	this.street = street;
	this.district = district;
	this.complement = complement;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getNumber() {
	return number;
}

public void setNumber(int number) {
	this.number = number;
}

public int getPostcode() {
	return postcode;
}

public void setPostcode(int postcode) {
	this.postcode = postcode;
}

public String getStreet() {
	return street;
}

public void setStreet(String street) {
	this.street = street;
}

public String getDistrict() {
	return district;
}

public void setDistrict(String district) {
	this.district = district;
}

public String getComplement() {
	return complement;
}

public void setComplement(String complement) {
	this.complement = complement;
}

@Override
public String toString() {
	return "Address {id=" + id + ", number=" + number + ", postcode=" + postcode + ", street=" + street + ", district="
			+ district + ", complement=" + complement + "}";
}

}
