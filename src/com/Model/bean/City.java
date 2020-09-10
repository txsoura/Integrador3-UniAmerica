package com.Model.bean;

public class City extends State {
	private int id;
	private String name,code;
	
	public City() {
	}

	public City(int CountryId, String CountryName, String CountryCode, int StateId, String StateName, String StateCode, int id, String name, String code) {
		super(CountryId,CountryName,CountryCode,StateId,StateName,StateCode);
		this.id = id;
		this.name = name;
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "City {id=" + id + ", name=" + name + ", code=" + code + "}";
	}
}
